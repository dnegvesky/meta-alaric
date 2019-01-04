PR = "r0"

FILESEXTRAPATHS_prepend := "${THISDIR}/files/v2014.10:"

#DEPENDS += "u-boot-mkimage-native"

#use revision corresponding to tag 'rel_socfpga_v2014.10_arria10_bringup_16.07.01_pr'
SRCREV = "01e2c2231ba59b7f941e200d500cd5a37fd0a257"

#SRCREV_FORMAT = "alaric"
#SRCREV_alaric = "${AUTOREV}"

SRC_URI_append += "\
	file://uboot.patch \
	"

 
