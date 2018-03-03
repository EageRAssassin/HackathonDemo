package MainDemo;
import org.rosuda.REngine.*;
import org.rosuda.REngine.Rserve.*;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.rosuda.REngine.REXPMismatchException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// use the rJava Package, use the R function

public class Rfunction {
	

	public static void main(String[] args)  {
		// read the csv file for output of the script
		//Runtime.getRuntime().exec("Rscript myScript.R"); 
		
		   String csvFile = "/Users/mkyong/csv/country.csv";
		   //load it in the doc under the file 
		  
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";

	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] country = line.split(cvsSplitBy);

	                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

	                
	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	    }
	}
	
	








//using Rengine
//		Rfunction rfunction = new Rfunction();
//		System.out.println("Rengine created, waiting for R");
//		 
//    }
//	
//	/** * import R, use the function */
//    @SuppressWarnings("deprecation")
//    public void method2(){
//        // R function path 
//        String filePath = "D:\\1.R";
//
//        // initialize ... 
//        Rengine engine = new Rengine(null, false, null);
//        System.out.println("Rengine created, waiting for R");
//
//        // waiting... 
//        if (!engine.waitForR()) {
//            System.out.println("Cannot load R");
//            return;
//        }
//        // copy the path to R 
//        engine.assign("fileName", filePath);
//        // execute file in R, load function to R and use later
//        engine.eval("source(fileName)");
//        System.err.println("R file load complete");
//
//        {
//            //  take parameter and store it in a object 
//            REXP rexp = engine.eval("test_no_param()");
//            System.err.println(rexp);
//            // 
//            double d = rexp.asDouble();
//            System.err.println(d);
//            System.err.println("---------------1");
//        }

	

