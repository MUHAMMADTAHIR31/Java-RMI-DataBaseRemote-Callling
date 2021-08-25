import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;
import java.io.*;


public class DynamicServer{
	
	public static void main(String arg[]){

		//already set from cmd-line, therefore no need to do hard-code
		//System.setProperty("java.security.policy","sachal.policy");
	
		if(System.getSecurityManager()==null)
		System.setSecurityManager(new RMISecurityManager());

		Properties p=System.getProperties();
		String url=p.getProperty("java.rmi.server.codebase");

		try{
			
			Class server=RMIClassLoader.loadClass(url,"DBManagerImp");

			Object obj=server.newInstance();	
			Remote remote=(Remote)obj;
		
			Registry registry=LocateRegistry.createRegistry(1099);
			registry.rebind("DBManagerImp",remote);
			
			System.out.println("Server bound in registry Started");
		}catch(Exception e){
			e.printStackTrace();
		}	
	}  
}