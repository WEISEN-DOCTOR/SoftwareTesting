package cn.tjuscs.one;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class testing {
	private int money;
	private Number n = null;
	
	@Before
	public void setup() {
		n=new Number();
	}
	
	public testing(int money) {
		this.money = money;
	}
	
	@Parameters
	public static Collection<Object> getData(){
		return Arrays.asList(new Object[] {37, 54, 4, 99, -1, 0, 3.12, 88, 50});
}
	
	@Test
	public void test() {
		assertTrue(n.number(this.money));
	}

}
