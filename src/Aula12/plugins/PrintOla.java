package Aula12.plugins;

import Aula12.IPlugin;

public class PrintOla implements IPlugin{

	@Override public void fazQualQuerCoisa(){
		System.out.println("Ola!");
	}
}
