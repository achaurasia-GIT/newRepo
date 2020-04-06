package APITesting.com.org.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*; 
public class GetRequest {
	//getting city weather by city name
	@Test  
	public void test1(){
		Response resp = when().
				get("http://api.openweathermap.org/data/2.5/weather?q=london&appid=c613ea367632a8ce83e3b3562a4242fd");
		
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
		
		   
	}
	//error code must be recieved after sending incorrect api data - city
	@Test
	public void test2(){
		Response resp = when().
				get("http://api.openweathermap.org/data/2.5/weather?q=londn&appid=c613ea367632a8ce83e3b3562a4242fd");
		
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 404);
		
		
	}
	//parameterization of api - @parameters : q,appid
	@Test
	public void test3(){
		//city name
		String cityName="london";
		String key="c613ea367632a8ce83e3b3562a4242fd";
		
		//Response resp = given().
						given().
						parameter("q", cityName).
						parameter("appid",key).
						when().
						get("http://api.openweathermap.org/data/2.5/weather").
						then().
						assertThat().statusCode(200);
						
		//System.out.println(resp.getHeader("Content-Length"));
		//Assert.assertEquals(resp.getStatusCode(), 200);
		
		
	}
	
	//get all the jason data from 
		@Test
		public void test4(){
			//city name
			String cityName="Noida";
			String key="c613ea367632a8ce83e3b3562a4242f";
			
			Response resp = given().
							given().
							parameter("q", cityName).
							parameter("appid",key).
							when().
							get("http://api.openweathermap.org/data/2.5/weather");
							
							
			System.out.println("TEST 4"+resp.asString());
			Assert.assertEquals(resp.getStatusCode(), 400);
			
			
		}
	
		//get all the jason data from  using zip code and country
		//uri - api.openweathermap.org/data/2.5/weather?zip=94040,us
				@Test
				public void test5(){
					//city name
					String zip="248001,in";
					String key="c613ea367632a8ce83e3b3562a4242fd";
					
					Response resp = given().
									given().
									parameter("q", zip).
									parameter("appid",key).
									when().
									get("http://api.openweathermap.org/data/2.5/weather");
									
									
					
					
				}
			
				
			//get content from jason	
				@Test
				public void test6(){
					//city name
					String zip="248001,in";
					String key="c613ea367632a8ce83e3b3562a4242fd";
					
					String weatherreport = given().
									given().
									parameter("q", zip).
									parameter("appid",key).
									when().
									get("http://api.openweathermap.org/data/2.5/weather").
									then().
									contentType(ContentType.JSON).
									extract().
									path("weather[0].description");
					System.out.println("Test 6"+weatherreport);
					
					
				}
				
				
				//get content for corona	
				@Test
				public void test7(){
					
					//String country = "..India[?(@.date=\"2020-3-25\")]";
					Response resp = 
									when().
									get("https://pomber.github.io/covid19/timeseries.json");
									
									
									
									
					String coronaCases = 	resp.		
									then().
									contentType(ContentType.JSON).
									extract().
									jsonPath().getString("India[67]");
					System.out.println("\n"+coronaCases+"\n");
					
					
					
					//System.out.println(resp.getHeader("$...temp"));
					//Assert.assertEquals(resp.getStatusCode(), 200);
					/*fetch("https://pomber.github.io/covid19/timeseries.json")
					  .then(response => response.json())
					  .then(data => {
					    data["Argentina"].forEach(({ date, confirmed, recovered, deaths }) =>
					      console.log(`${date} active cases: ${confirmed - recovered - deaths}`)
					    )
					  })*/
					
				}
			
				
				
				
				
}
