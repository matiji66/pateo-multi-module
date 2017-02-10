package org.com.pateo.common;

import org.apache.log4j.Logger;

class Test {

	final Logger log = Logger.getLogger(Test.class);

	public void test() {
		log.info("hello this is log4j info log");
	}
}

public class LoggerUsage {
	public static void main(String[] args) {
		new Test().test();
	}
}
