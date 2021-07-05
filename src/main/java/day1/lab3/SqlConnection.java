package day1.lab3;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "sql")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public class SqlConnection implements Connection {

	public SqlConnection() {
		System.out.println("SqlConnection constructor");
	}

	public void open() {
		System.out.println("SqlConnection open");

	}

	public void close() {
		System.out.println("SqlConnection close");

	}

}
