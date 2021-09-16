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
	public class NavegationUol extends Automation {

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

		public NavegationUol(String executionName, DataDictionary data) {
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

				Element Search1	= new Element("xpath", "//span[@class='HU_menu__title' and text()='Esporte']");
				Element Search2 = new Element("xpath", "//span[@class='HU_menu__title' and text()='Carros']");
				Element Search3 = new Element("xpath", "//span[@class='HU_menu__title' and text()='Coronavírus']");
				Element Search4 = new Element("xpath", "//span[@class='HU_menu__title' and text()='Folha']");
				Element Search5 = new Element("xpath", "//span[@class='HU_menu__title' and text()='Economia']");
				Element home = new Element("xpath", "//a[@href='https://www.uol.com.br/']");
				Element resultado = new Element("xpath", "//div[@class='ticker-financial-market']");
				//Element resultSearch = new Element("xpath", "//a[@class='label-teams-nav']");
				//Element resultSearch2 = new Element("xpath", "//a[@class='label-teams-nav']");
				//Element resultSearch3 = new Element("xpath", "//a[@class='label-teams-nav']");
				//Element resultSearch4 = new Element("xpath", "//a[@class='label-teams-nav']");
				//Element resultSearch5 = new Element("xpath", "//a[@class='label-teams-nav']");

							
				efa.executeAction(Action.Navigate, efa.getGlobalData().getData("vURL"));
				efa.executeAction(Action.Click, Search1);
				WebDriverWait wait1 = new WebDriverWait(efa.getDriver(), 10); 
				efa.executeAction(Action.Click, home);
				
				efa.executeAction(Action.Navigate, efa.getGlobalData().getData("vURL"));
				efa.executeAction(Action.Click, Search2);
				WebDriverWait wait2 = new WebDriverWait(efa.getDriver(), 10); 
				efa.executeAction(Action.Click, home);
				
				efa.executeAction(Action.Navigate, efa.getGlobalData().getData("vURL"));
				efa.executeAction(Action.Click, Search3);
				WebDriverWait wait3 = new WebDriverWait(efa.getDriver(), 10); 
				efa.executeAction(Action.Click, home);
				
				efa.executeAction(Action.Navigate, efa.getGlobalData().getData("vURL"));
				efa.executeAction(Action.Click, Search4);
				WebDriverWait wait4 = new WebDriverWait(efa.getDriver(), 10); 
				efa.executeAction(Action.Click, home);
				
				efa.executeAction(Action.Navigate, efa.getGlobalData().getData("vURL"));
				efa.executeAction(Action.Click, Search5);
				WebDriverWait wait5 = new WebDriverWait(efa.getDriver(), 10); 
				efa.executeAction(Action.Click, home);
				
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
	
