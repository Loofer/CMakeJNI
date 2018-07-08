# CMake方式引入FFmpeg

## 版本环境 
* FFmpeg 4.0.1
* Linux CentOS 7 
* NDK 版本 android-ndk-r17b
* Android Studio 3.1.2

## 配置修改
**configure**
```
#SLIBNAME_WITH_MAJOR='$(SLIBNAME).$(LIBMAJOR)'
#LIB_INSTALL_EXTRA_CMD='$$(RANLIB) "$(LIBDIR)/$(LIBNAME)"'
#SLIB_INSTALL_NAME='$(SLIBNAME_WITH_VERSION)'
#SLIB_INSTALL_LINKS='$(SLIBNAME_WITH_MAJOR) $(SLIBNAME)'
SLIBNAME_WITH_MAJOR='$(SLIBPREF)$(FULLNAME)-$(LIBMAJOR)$(SLIBSUF)'  
LIB_INSTALL_EXTRA_CMD='$$(RANLIB)"$(LIBDIR)/$(LIBNAME)"'  
SLIB_INSTALL_NAME='$(SLIBNAME_WITH_MAJOR)'  
SLIB_INSTALL_LINKS='$(SLIBNAME)'  

```
**build.sh**
```
#!/bin/bash
ADDI_CFLAGS="-marm"
API=27
PLATFORM=arm-linux-androideabi
CPU=armv7-a
NDK=/usr/local/ffmpeg/android-ndk-r17b # 修改自己本地的ndk路径
SYSROOT=$NDK/platforms/android-$API/arch-arm/
ISYSROOT=$NDK/sysroot
ASM=$ISYSROOT/usr/include/$PLATFORM
TOOLCHAIN=$NDK/toolchains/$PLATFORM-4.9/prebuilt/linux-x86_64
OUTPUT=$(pwd)/android/$CPU #自己指定一个输出目录
function build_one
{
./configure \
--prefix=$OUTPUT \
--enable-shared \
--enable-postproc \
--enable-gpl \
--disable-static \
--disable-doc \
--disable-ffmpeg \
--disable-ffplay \
--disable-ffprobe \
--disable-doc \
--disable-symver \
--cross-prefix=$TOOLCHAIN/bin/arm-linux-androideabi- \
--target-os=android \
--arch=arm \
--enable-cross-compile \
--sysroot=$SYSROOT \
--extra-cflags="-I$ASM -isysroot $ISYSROOT -Os -fpic -marm" \
--extra-ldflags="-marm" \
$ADDITIONAL_CONFIGURE_FLAG
}
build_one

```

## 参考资料
**编译FFmpeg4.0.1并移植到Android app中使用**

[https://blog.csdn.net/bobcat_kay/article/details/80889398](https://blog.csdn.net/bobcat_kay/article/details/80889398)

**FFmpeg(3.3.2)移植Android平台**

[https://blog.csdn.net/ywl5320/article/details/75040724](https://blog.csdn.net/ywl5320/article/details/75040724)

**Mac下cmake编译FFmpeg-4.0**

[https://blog.csdn.net/android_wql/article/details/80349714](https://blog.csdn.net/android_wql/article/details/80349714)

**NDK下载地址**

[https://developer.android.com/ndk/downloads/](https://developer.android.com/ndk/downloads/)

**FFmpeg下载地址**

[https://ffmpeg.org/download.html#releases](https://ffmpeg.org/download.html#releases)



