package Aula7;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Voo{
	String hora;
	String voo;
	String companhia;
	String origem;
	String atraso;
	String obs;
	
	public Voo(String hora, String voo, String origem, String atraso){
		this.hora = hora;
		this.voo = voo;
		this.origem = origem;
		this.atraso = atraso;
	}
	
	public Voo(String hora, String voo, String origem){
		this.hora = hora;
		this.voo = voo;
		this.origem = origem;
		this.atraso = null;
	}
	
	public String getAtraso(){
		if(this.atraso == null)
			return " ";
		return this.atraso;
	}
	
	public String getHora(){
		return this.hora;
	}
	
	public String getVoo(){
		return this.voo;
	}
	
	public String getOrigem(){
		return this.origem;
	}
	
	public String getCompanhia(){
		String[] id;
		
		id = this.voo.split(" ");
		
		if(id[0].length()>2){
			id = id[0].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
		}
		
		if(id[0].equals("TP")){
			return "TAP Portugal";
		}else if(id[0].equals("AEA")){
			return "Air Europa";
		}else if(id[0].equals("IB")){
			return "Iberia";
		}else if(id[0].equals("TO")){
			return "Transavia France";
		}else if(id[0].equals("FR")){
			return "Ryanair";
		}else if(id[0].equals("EZY")){
			return "EasyJet Airlines";
		}else if(id[0].equals("S4")){
			return "Sata Internacional";
		}
		
		return "";
	}
	
	public String obs(){
		
		try{
			
		Calendar c = Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date date = sdf.parse(this.hora + ":00");
		String[] minutos = this.atraso.split(":");
		
		c.setTime(date);
		c.add(Calendar.MINUTE, Integer.parseInt(minutos[1]));
		
		return sdf.format(c.getTime());
		
		}catch(Exception e){
			
		}
			
		return "";
	}
	
}
