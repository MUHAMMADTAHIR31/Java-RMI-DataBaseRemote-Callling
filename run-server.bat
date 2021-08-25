javac DynamicServer.java
java -Djava.security.policy=sachal.policy -Djava.rmi.server.codebase=http://localhost:80/usindh/ DynamicServer
pause
