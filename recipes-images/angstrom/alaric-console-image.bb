require recipes-images/angstrom/console-image.bb

IMAGE_INSTALL += " \
	bash \
	alaric-fpga-init \
	alaric-lighttpd-conf \
	alaric-linux-firmware \
	alaric-usb-gadget \
	alaric-webcontent \
	alaric-x11vnc-init \
	alaric-xfce-default-config \
	alaric-xfce-init \
	ethtool \
	gcc \
	gdb \
	gdbserver \
	gnuplot \
	i2c-tools \
	iperf \
	iw \
	kernel-dev \
	kernel-image \
	kernel-modules \
	lighttpd \
	lighttpd-module-cgi \
	net-tools \
	nfs-utils-client \
	packagegroup-sdk-target \
	python \
	tar \
	usbutils \
	vim \
	vim-vimrc \
"
export IMAGE_BASENAME = "alaric-console-image"

#overload timestamp function in image.bbclass

rootfs_update_timestamp () {
        date -u +%4Y%2m%2d%2H%2M -d "+1 day">${IMAGE_ROOTFS}/etc/timestamp
}

EXPORT_FUNCTIONS rootfs_update_timestamp

# add later
#	alaric-fpga-leds \
