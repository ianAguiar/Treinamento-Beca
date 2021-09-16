package utilitarios;

		import java.text.SimpleDateFormat;
		import java.util.Arrays;
		import java.util.Date;
		import java.util.List;

		import org.apache.activemq.broker.BrokerService;
		import org.junit.After;
		import org.junit.AfterClass;
		import org.junit.Before;
		import org.junit.BeforeClass;
		import org.junit.Rule;
		import org.junit.rules.TestName;
		import org.openqa.selenium.remote.DesiredCapabilities;

		import com.everis.Action;
		import com.everis.EFA;
		import com.everis.EFAFactory;
		import com.everis.EFASingleton;
		import com.everis.ExecutionInfo;
		import com.everis.GlobalData;
		import com.everis.data.DataLoad;
		import com.everis.data.broker.BrokerConsumer;

		//import web.CoreWeb;

		public class Automation {
			public EFA efa;
			static String timeStamp;
			public GlobalData globalData;

			static String[] fullClassName;

			// private static CoreWeb web;
			private static BrokerService brokerService;
			private static boolean useBroker = false;

			@Rule
			public TestName currentTest = new TestName();

			/**
			 * Load data from input file or data base
			 * 
			 * @return List with data
			 * @throws Exception
			 */
			public static List<Object> loadData() throws Exception {
				fullClassName = new Throwable().getStackTrace()[1].getClassName().toString().split("\\W");

				ExecutionInfo execInfo = new ExecutionInfo();
				execInfo.setTestSuite(fullClassName[fullClassName.length - 2]);
				execInfo.setTestName(fullClassName[fullClassName.length - 1]);
				timeStamp = new SimpleDateFormat("yyyyMMdd-HHmmss-SSS").format(new Date());

				return Arrays.asList(new DataLoad(execInfo).load());
			}

			@Before
			public void beforeRunTest() throws Exception {
				DesiredCapabilities capabilities = null;
				ExecutionInfo execInfo = new ExecutionInfo();
				execInfo.setTestSuite(fullClassName[fullClassName.length - 2]);
				execInfo.setTestName(fullClassName[fullClassName.length - 1]);
				execInfo.setExecutionTimestamp(timeStamp);

				/*
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-extensions");
				options.addArguments("disable-infobars");
				capabilities = DesiredCapabilities.chrome();
				capabilities.setJavascriptEnabled(true);
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				*/
				
				if (System.getProperty("feature") == null) {
					efa = EFAFactory.getEFA(globalData.getData("Driver"), capabilities);
					efa.setExecutionInfo(execInfo);
					efa.setGlobalData(globalData);
				} else {
					efa = EFASingleton.getInstance();
					efa.setExecutionInfo(execInfo);
					efa.setGlobalData(globalData);
				}
			}

			/**
			 * Initialize the framework
			 * 
			 * @throws Exception
			 */
			@BeforeClass
			public static void beforeExecution() throws Exception {
				try {
					// configure the broker
					useBroker = Boolean.parseBoolean(System.getProperty("useBroker", "FALSE"));
					if (useBroker) {
						brokerService = new BrokerService();
						brokerService.setBrokerName("efa3broker");
						brokerService.setPersistent(false);
						brokerService.addConnector("tcp://localhost:61616");
						brokerService.start();
						BrokerConsumer.runConsumer();
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
			}

			/**
			 * Scenario - Postcondition for the test
			 * 
			 * @throws Exception
			 */
			@After
			public void afterRunTest() throws Exception {
				try {
					efa.executeAction(Action.ClearSession, null);
					efa.finishExecution();
				} finally {
					efa.finishTool();
				}
			}

			/**
			 * Execution - Postcondition for the execution
			 * 
			 * @throws Exception
			 */
			@AfterClass
			public static void afterExecution() throws Exception {
				if (useBroker) {
					BrokerConsumer.emptyQueueAndStop();
					Thread.sleep(1000);
					brokerService.stop();
				}
			}

	}
