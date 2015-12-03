package Aula12;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class getters {

	private static Class<?> c;
	
	public getters(Class<?> c){
		this.c = c;
	}
	
	public String getChar(){
		String attr = "";
		
		attr += "Atributos: " + getAttributes() + "\n" + "Metodos: " + getMethods() + "\n" + "Interfaces: " + getInterfaces()  + "\n" + "Super Classes: " + getSuperClasses();
		
		return attr;
	}
	
	public String getAttributes(){
		String attr = "";
		for(Field f : c.getDeclaredFields()){
			attr += f.toString() + "\t";
		}
		return attr;
	}
	
	public String getMethods(){
		String methods = "";
		
		for(Method m: c.getDeclaredMethods()){
			methods += m.toString() + "\t";
		}
		
		return methods;
	}
	
	public String getInterfaces(){
		String interfaces = "";
		
		if (c.getInterfaces().length!=0){
			interfaces += " implements";
		}
		
		for(Class<?> cl : c.getInterfaces()){
			interfaces += cl.getSimpleName();
		}
		return interfaces;
	}
	
	public String getSuperClasses(){
		Class<?> cl = c.getSuperclass();
		
		if(cl.getSimpleName() == null || cl.getSimpleName().length()==0){
			return "";
		}
		return " extends " + cl.getSimpleName();
	}
	
	public String getConstructors(Class<?> classe){
		Constructor<?>[] cl = classe.getConstructors();
		String constructors = "";
		
		for (int i = 0; i < cl.length; i++) {
			constructors += "\t" + i + " - " + cl[i].toString() + "\n";
		}
		return constructors;
	}
	
	private Object createObject(Constructor<?> cons){
		Scanner sc = new Scanner(System.in);
		Class<?>[] paramTypes = cons.getParameterTypes();
		Object[] paramsObj = new Object[paramTypes.length];
		
		for (int i = 0; i < paramTypes.length; i++) {
			System.out.println(paramTypes[i].getSimpleName()+": ");
			
			switch(paramTypes[i].getSimpleName()){
			case "double":
				paramsObj[i] = sc.nextDouble();
				break;
			case "int":
				paramsObj[i] = sc.nextInt();
				break;
			case "char":
				paramsObj[i] = sc.next().charAt(0);
				break;
			case "String":
				paramsObj[i] = sc.next();
				break;
			default:
				paramsObj[i] = instanceByConstructor(paramTypes[i]);
				break;
			}
		}
		
		Object obj = new Object();
		
		try {
			obj = cons.newInstance(paramsObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  obj;
		
	}
	
	private Object instanceByConstructor(Class<?> p){
		System.out.println(getConstructors(c));
		System.out.print("Número do construtor: ");
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();//= 0; //default!
		
		Object inst = createObject(p.getDeclaredConstructors()[n]);
		return inst;
	}
	
	public Object instance(){
		return instanceByConstructor(c);
	}
	
	public ArrayList<String> metodos(){
		ArrayList<String> list = new ArrayList<>();
		for(Method m: c.getDeclaredMethods()){
			 list.add(m.toString());
		}	
		return list;
	}
	
	public void doMethods(Object obj){
		ArrayList list = metodos();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("Escolha o metodo: ");
		
		
		
	}
	
	
	
	
}
