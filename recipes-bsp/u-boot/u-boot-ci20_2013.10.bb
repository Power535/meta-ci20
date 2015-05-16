require u-boot.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PROVIDES = "u-boot"

# SPL build
UBOOT_BINARY = "u-boot-dtb.bin"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.img"
UBOOT_SYMLINK = "u-boot-${MACHINE}.img"

# No patches for other machines yet
COMPATIBLE_MACHINE = "ci20"

BRANCH = "ci20-v2013.10"
SRC_URI = "git://github.com/MIPS/CI20_u-boot;branch=${BRANCH}"

SRC_URI += "file://0001-mmc-up-spt-text.patch "

SRCREV = "b253ee9554899f0cc8d0c0147e6d110693a140aa"

PV = "${BRANCH}"

LIC_FILES_CHKSUM = "file://README;beginline=2;endline=5;md5=3c0cec9329dbcd30c8b9e7f56a12b71e"

S = "${WORKDIR}/git"

CFLAGS += " -fno-pic -mno-abicall"
