FROM alfa/jboss-fuse-6.3

COPY esbconfig/HotDeployFeatures.xml /opt/jboss/jboss-fuse/deploy

#copy setup files
COPY esbconfig/system.properties /opt/jboss/jboss-fuse/etc
COPY esbconfig/users.properties /opt/jboss/jboss-fuse/etc
COPY esbconfig/org.ops4j.pax.url.mvn.cfg /opt/jboss/jboss-fuse/etc
COPY esbconfig/org.ops4j.pax.web.cfg /opt/jboss/jboss-fuse/etc
COPY esbconfig/ru.alfastrah.interplat4.cfg /opt/jboss/jboss-fuse/etc
COPY esbconfig/org.ops4j.pax.logging.cfg /opt/jboss/jboss-fuse/etc
COPY esbconfig/setenv /opt/jboss/jboss-fuse/bin
COPY --chown=jboss:jboss esbconfig/org.apache.karaf.features.cfg /opt/jboss/jboss-fuse/etc

#copy project (product) bundles to fuse
COPY target/*.jar /opt/jboss/jboss-fuse/deploy