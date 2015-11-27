package Aula5;
import java.io.IOException;

public interface ReadWriteInterface {
	public abstract void read() throws IOException;
	public abstract void write() throws IOException;
	public abstract void save(String nome, String cc, String data);
}
