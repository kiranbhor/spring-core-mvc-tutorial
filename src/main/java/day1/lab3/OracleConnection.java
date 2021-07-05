package day1.lab3;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component(value =  "ora")
@Lazy
public class OracleConnection implements Connection {

	
	public OracleConnection() {
		System.out.println("OracleConnection constructor");
	}
	
	public void open() {
		System.out.println("OracleConnection open");
		
	}

	public void close() {
		System.out.println("OracleConnection close");
		
	}

}
