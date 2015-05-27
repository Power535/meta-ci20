inherit kernel
require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-ci20:"

COMPATIBLE_MACHINE = "ci20"

LINUX_VERSION = "3.18.14"

KBRANCH = "ci20-3.18.y"

SRC_URI = "git://github.com/akuster/linux-stable.git;bareclone=1;branch=${KBRANCH}"

SRCREV = "c3aa36620c31c72c7e007c6e549b43ba7fccd4e0"

PV = "${LINUX_VERSION}+git${SRCPV}"

SRC_URI += "file://0001-jz4740-fix-irq-issue.patch \
            file://0001-brcm-add-firmware-for-sdio-card.patch \
            file://defconfig"

do_configure_preappend () {
    install -d ${S}/firmware/brcm
    cp ${WORKDIR}/defconfig ${B}/.config
}
