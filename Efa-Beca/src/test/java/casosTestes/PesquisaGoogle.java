package casosTestes;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.everis.Action;
import com.everis.Element;
import com.everis.GlobalData;
import com.everis.data.DataDictionary;

import utilitarios.Automation;
import utilitarios.Parallelized;

	@RunWith(Parallelized.class)
	public class PesquisaGoogle extends Automation {

		String mensaje = "";
		String executionName = "";

		/**
		 * Script: Web simple form test
		 * 
		 * @param executionName
		 *            Test name
		 * @param data
		 *            Data for current interaction
		 */

		public PesquisaGoogle(String executionName, DataDictionary data) {
			this.executionName = executionName;
			globalData = new GlobalData();
			globalData.load(data);
		}

		/**
		 * Load data for all interactions
		 * 
		 * @return List all interactions with data for the test
		 * @throws Exception
		 */
		@Parameterized.Parameters(name = "{0}")
		public static List<Object> loadTestData() throws Exception {
			// Call data loader for all interactions
			return loadData();
		}

		@Before
		public void beforeTest() throws Exception {
			efa.getExecutionInfo().setExecutionName(executionName);
		}

		// ******************
		// * Simple example *
		// ******************

		@Test
		public void script() {
			try {

				Element inputSearch	= new Element("xpath", "//input[@type='search']");
				Element resultado = new Element("xpath", "//div[@id='pageSearchResultsBody']/div/div/span");
				Element btnPesquisa	= new Element("xpath", "//button[@class='search-bar__submit-button']");

							
				efa.executeAction(Action.Navigate, efa.getGlobalData().getData("vURL"));
				efa.executeAction(Action.SendKeys, inputSearch, efa.getGlobalData().getData("vWord"));
				efa.executeAction(Action.Click, btnPesquisa);
							
				WebDriverWait wait = new WebDriverWait(efa.getDriver(), 10); 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='pageSearchResultsBody']/div/div/span")));
				
							
				efa.executeAction(Action.GetText, resultado);
				
				mensaje="Result OK";
				
			} catch (Exception e) {
				e.printStackTrace();
				mensaje=e.getMessage();
			} finally {
				efa.getExecutionInfo().setResult(mensaje);
			}

		}
		
	}
	
