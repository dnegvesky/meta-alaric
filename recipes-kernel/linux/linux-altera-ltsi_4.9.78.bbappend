PR = "r0"
FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_alaric += " \
				file://socfpga-4.9.78-ltsi/cfg/socfpga_rxc_defconfig \
				file://socfpga-4.9.78-ltsi/cfg/altvipfb.cfg \
				file://socfpga-4.9.78-ltsi/cfg/block.cfg \
				file://socfpga-4.9.78-ltsi/cfg/cma.cfg \
				file://socfpga-4.9.78-ltsi/cfg/configfs.cfg \
				file://socfpga-4.9.78-ltsi/cfg/gpio-keys.cfg \
				file://socfpga-4.9.78-ltsi/cfg/led-triggers.cfg \
				file://socfpga-4.9.78-ltsi/cfg/usb-gadget.cfg \
				file://socfpga-4.9.78-ltsi/patches/0001-add-alaric-devicetree.patch \
				"

# see here for recipe debug: https://www.yoctoproject.org/docs/2.6/kernel-dev/kernel-dev.html#creating-a-defconfig-file
# first file line above adds the rxc defconfig; manual says to rename to 'defconfig' but let's see if it works leaving the original name
