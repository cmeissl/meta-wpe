# Copyright (C) 2016 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "WPE initramfs rootfs image"
LICENSE = "MIT"

IMAGE_FEATURES += " \
    package-management \
"
require recipes-core/images/rpi-basic-image.bb
require wpe-image.inc
