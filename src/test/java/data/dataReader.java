//package data;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.HashMap;
//import java.util.List;
//
//import org.apache.commons.io.FileUtils;
//
//import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
//import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
//
//public class dataReader {
//
//	public List<HashMap<String, String>> getJsonDatatoMap() throws IOException {
//		
//		//read json to string
//		String JsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"src//test//java//data//PurchaseOrder.json" ), StandardCharsets.UTF_8);
//		
//		
//		//convert string to hashMap
////		ObjectMapper mapper = new ObjectMapper();
////		List<HashMap<String, String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>(){});
//		
////		return data;
//		
//	}
//
//}
