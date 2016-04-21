project :
D:\dt\apache-maven-3.0.4\bin\mvn archetype:generate -DinteractiveMode=false -DarchetypeGroupId=org.openjdk.jmh -DarchetypeArtifactId=jmh-java-benchmark-archetype -DarchetypeVersion=1.5.2 -DgroupId=com.catamania -DartifactId=jmh-sample-benchmak -Dversion=1.0-SNAPSHOT

build :
D:\dt\apache-maven-3.0.4\bin\mvn clean package

run :
D:\dt\jdk1.8.0_60\bin\java -jar target/benchmarks.jar