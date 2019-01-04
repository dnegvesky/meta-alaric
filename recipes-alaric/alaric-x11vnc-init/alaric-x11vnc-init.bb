SUMMARY = "Alaric X11VNC Startup"
DESCRIPTION = "Alaric scripts to start x11vnc"
AUTHOR = "Dan Negvesky <dnegvesky@reflexces.com>"
SECTION = "alaric"

PV = "1.0"
PR = "r0"

inherit systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://alaric-x11vnc-init.service \
           file://alaric-x11vnc-init.sh \
          "

do_install() {
	install -d ${D}${base_libdir}/systemd/system
	install -m 0644 ${WORKDIR}/*.service ${D}${base_libdir}/systemd/system

	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/*.sh ${D}${bindir}

}

FILES_${PN} = "${base_libdir}/systemd/system/alaric-x11vnc-init.service \
               ${sysconfdir}/systemd/ \
               ${bindir}/alaric-x11vnc-init.sh \
              "

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "alaric-x11vnc-init.service"
