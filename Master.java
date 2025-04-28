import java.util.Scanner;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.*;



public class Master {

	public static void main(String[] args) {

// Objects
		Scanner sc = new Scanner(System.in);

//#####################################################################
		String mas = "A11yMAS";
		String sev1 = "A11ySev1";
		String sev2 = " A11ySev2";
		String sev3 = " A11ySev3";
		String sev4 = "A11ySev4";
		String accessibility = " accessibility";
		String bm = " Benchmark";
		String hcl = " HCL";
		String win = " Win11";
		String response;
       JOptionPane.showMessageDialog(null,"HELLO\nThis is AUTOMATED BUG REVIEW TOOL\nclick on OK to proceed ahead", "AUTOMATED BUG REVIEW TOOL", 2);
       response = JOptionPane.showInputDialog(null, "WANT TO CHECK BUGS\n 1 for YES \n 2 for NO");
       int check=Integer.parseInt(response);
		switch (check) {
		case 1: {
			System.out.println("here are the bugs which are logged");
			try {
				
				File file = new File("bugs.xlsx"); 
				// file obj
				FileInputStream fis = new FileInputStream(file);
				
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				// creating a Sheet object
				XSSFSheet sheet = wb.getSheetAt(0);
				// iterating excel file
				Iterator<Row> itr = sheet.iterator();
				while (itr.hasNext()) {
					Row row = itr.next();
					// iterating over each column
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case STRING: // field that represents string cell type
							System.out.print(cell.getStringCellValue() + "    ");
							break;
						case NUMERIC: // field that represents number cell type
							System.out.print(cell.getNumericCellValue() + "    ");
							break;
						default:
						}
					}
					System.out.println("");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
//##################################################################################################################################################################################

			int bug = 0;

			while (bug < 1) {

				System.out.println("which bug you want to check");
				System.out.println("Please enter a number");
				int no = sc.nextInt();

				System.out.println("check the " + no + " bug in the list");
				System.out.println("checking Title");
				Master mt = new Master();
				
				String titleOutput = mt.ReadCellData(no, 3);
				System.out.println(titleOutput);

				if (titleOutput.length() < 200) {
					System.out.println(" Title length is under 200 char ");
				} else {
					System.out.println(" @tester Title length is more then  50 char ");
					System.out.println(" Make the titlr more crisp and short ");
				}
//######################################################################################################################################################################				

				char t = titleOutput.charAt(1);
				char t2 = titleOutput.charAt(2);
				char t3 = titleOutput.charAt(4);

				switch (t) {
				case 75: {
					System.out.println("This is a Keyboard bug ");
				}
					break;

				case 70: {
					System.out.println("This is a Functional bug ");
				}
					break;
				case 80: {

					switch (t3) {
					case 103: {
						System.out.println("This is a Programmatic access bug");
					}
						break;
					case 99: {
						System.out.println("This is a Process bug ");
					}
						break;
					default:
						System.out.println("error");
					}
				}
					break;

				case 83: {
					switch (t2) {
					case 99: {
						System.out.println("This is a Screen reader bug");
					}
						break;

					case 117: {
						System.out.println("This is a Supporting the platform bug ");
					}
						break;

					default:
						System.out.println("error");
					}

				}
					break;

				case 85: {
					System.out.println("This is a Usable bug");
				}
					break;

				case 86: {
					System.out.println("This is a Visual requirements bug");
				}
					break;

				default:
					System.out.println("error");
				}

				System.out.println("Title is correct");
//########################################################################################################################################################################################				

				String tagOutput = mt.ReadCellData(no, 6);
				System.out.println(tagOutput);

				String[] tagsplit = tagOutput.split(";");

				String[] tagsch = { " HCL", " accessibility", " Benchmark" };

				boolean foundAll = Arrays.asList(tagsplit).containsAll(Arrays.asList(tagsch));
				System.out.println("checking  for the Mandatory Tags");
				System.out.println("The mandatory tag are present = " + foundAll);

//################################################################################################################################################################################

				switch (t) {
				case 75: {
					System.out.println("This is a Keyboard bug ");
					char sev = tagsplit[1].charAt(8); // mas
					System.out.println("This is a mas bug");

					switch (sev) {
					case 50: {
						if (tagsplit[1].contentEquals(sev2)) {
							System.out.println("The Sev2 tag is correct");
						} else {
							System.out.println("The Sev2 tag is incorrect");
						}
					}
						break;

					case 51: {
						if (tagsplit[1].contentEquals(sev3)) {
							System.out.println("The Sev3 tag is correct");
						} else {
							System.out.println("The Sev3 tag is incorrect");
						}
					}
						break;

					default:
						System.out.println("Incorrect Sev tags in the MAS bug");
					}

				}
					break;

				case 70: {
					System.out.println("This is a Functional bug ");
					char sevf = tagsplit[2].charAt(8); // fun
					System.out.println("The Functional bug");

					if (tagsplit[0].contentEquals(sev1)) {
						System.out.println("The Sev1 tag is correct");
					} else {
						System.out.println("The Sev1 tag is incorrect");

						System.out.println("Incorrect Sev tags in the Functional bug");
					}
				}
					break;
				case 80: {
					switch (t2) {
					case 103: {
						System.out.println("This is a Programmatic access bug");
						char sev = tagsplit[1].charAt(8); // mas
						System.out.println("This is a mas bug");

						switch (sev) {
						case 50: {
							if (tagsplit[1].contentEquals(sev2)) {
								System.out.println("The Sev2 tag is correct");
							} else {
								System.out.println("The Sev2 tag is incorrect");
							}
						}
							break;

						case 51: {
							if (tagsplit[1].contentEquals(sev3)) {
								System.out.println("The Sev3 tag is correct");
							} else {
								System.out.println("The Sev3 tag is incorrect");
							}
						}
							break;

						default:
							System.out.println("Incorrect Sev tags in the MAS bug");
						}
					}
						break;
					case 99: {
						System.out.println("This is a Process bug ");
						char sevf = tagsplit[2].charAt(8); // fun
						System.out.println("The AAT bug");

						switch (sevf) {
						case 50: {
							if (tagsplit[2].contentEquals(sev1)) {
								System.out.println("The Sev1 tag is correct");
							} else {
								System.out.println("The Sev1 tag is incorrect");
							}
						}
							break;

						case 51: {
							if (tagsplit[2].contentEquals(sev3)) {
								System.out.println("The Sev3 tag is correct");
							} else {
								System.out.println("The Sev3 tag is incorrect");
							}
						}
							break;

						default:
							System.out.println("Incorrect Sev tags in the MAS bug");
						}
					}
						break;
					default:
						System.out.println("error");
					}
				}
					break;

				case 83: {
					switch (t2) {
					case 99: {
						System.out.println("This is a Screen reader bug");
						char sev = tagsplit[1].charAt(8); // mas
						System.out.println("This is a mas bug");

						switch (sev) {
						case 50: {
							if (tagsplit[1].contentEquals(sev2)) {
								System.out.println("The Sev2 tag is correct");
							} else {
								System.out.println("The Sev2 tag is incorrect");
							}
						}
							break;

						case 51: {
							if (tagsplit[1].contentEquals(sev3)) {
								System.out.println("The Sev3 tag is correct");
							} else {
								System.out.println("The Sev3 tag is incorrect");
							}
						}
							break;

						default:
							System.out.println("Incorrect Sev tags in the MAS bug");
						}
					}
						break;

					case 117: {
						System.out.println("This is a Supporting the platform bug ");
						char sev = tagsplit[1].charAt(8); // mas
						System.out.println("This is a mas bug");

						switch (sev) {
						case 50: {
							if (tagsplit[1].contentEquals(sev2)) {
								System.out.println("The Sev2 tag is correct");
							} else {
								System.out.println("The Sev2 tag is incorrect");
							}
						}
							break;

						case 51: {
							if (tagsplit[1].contentEquals(sev3)) {
								System.out.println("The Sev3 tag is correct");
							} else {
								System.out.println("The Sev3 tag is incorrect");
							}
						}
							break;

						default:
							System.out.println("Incorrect Sev tags in the MAS bug");
						}
					}
						break;

					default:
						System.out.println("error");
					}

				}
					break;

				case 85: {
					System.out.println("This is a Usbale bug");

					if (tagsplit[0].contentEquals(sev4)) {
						System.out.println("The Sev4 tag is correct");
					} else {
						System.out.println("The Sev4 tag is incorrect");

						System.out.println("Incorrect Sev tags in the Usable bug");
					}

				}
					break;

				case 86: {
					System.out.println("This is a Visual requirements bug");
					char sev = tagsplit[1].charAt(8); // mas
					System.out.println("This is a mas bug");

					switch (sev) {
					case 50: {
						if (tagsplit[1].contentEquals(sev2)) {
							System.out.println("The Sev2 tag is correct");
						} else {
							System.out.println("The Sev2 tag is incorrect");
						}
					}
						break;

					case 51: {
						if (tagsplit[1].contentEquals(sev3)) {
							System.out.println("The Sev3 tag is correct");
						} else {
							System.out.println("The Sev3 tag is incorrect");
						}
					}
						break;

					default:
						System.out.println("Incorrect Sev tags in the MAS bug");
					}
				}
					break;

				default:
					System.out.println("error");
				}

//#############################################_------------------------------------------------------------------------------

//########################################################################################################################################################################################				

				System.out.println("checking Tags");

				System.out.println(tagOutput);

				String[] tagpool = { " HCL", " accessibility", " Benchmark", "A11yMAS", " A11ySev1", " A11ySev2",
						" A11ySev3", " A11ySev4", " Win11-Edge(Chromium)", " A11yUsable", "A11ySev1" , " Functional" ,
						" ENCOURAGED:InclusionBacklog-[f74cf0e8-f4de-47b9-9fa3-312425a5b0cc]", " InclusionBacklog",
						" InclusionBacklog-[Azure]", " InclusionBacklog-[AzureDNSPrivateResolver]", "A11YAAT" };

				int n = 0;

				while (n <= 2) {

					for (int i = 0; i < tagsplit.length; i++) {

						for (int j = 0; j < tagpool.length; j++) {

							if (tagsplit[i].contentEquals(tagpool[j])) {
								System.out.println("The " + tagsplit[i] + " tags is correct ");
								n++;

							} else {
								System.out.print("");
							}
						}

					}

					System.out.println("only " + n + " tag are correct out of the " + tagsplit.length);

				}

//#########################################################################################################################################	
				System.out.println("Who created the bug  ?");
				String CreatedbyOutput = mt.ReadCellData(no, 4);
				System.out.println(CreatedbyOutput);
//###########################################################################################################################################				
				System.out.println("What is the state of the Bug ?");
				String StateoOutput = mt.ReadCellData(no, 5);
				System.out.println(StateoOutput);

//####################################################################################################################################

				System.out.println("On which data the bug was logged ?");
				String dataOutput = mt.ReadCellData(no, 1);
				System.out.println(dataOutput);

				String[] bugdate = dataOutput.split("/");
				int d = Integer.parseInt(bugdate[1]);

				SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
				System.out.println("Current date is " + f.format(new Date()));

				String[] sladate = f.format(new Date()).split("/");
				int d1 = Integer.parseInt(sladate[1]);

				int sla = d + 3;

				int c = d1 - d;

				if (c <= 3) {
					System.out.println("in  sla ");
					System.out.println("Please assigne the bug befor " + sla);
				} else {
					System.out.println("out  sla ");
					System.out.println("Please assigne the bug now ");
				}

//########################################################################################################################################################################################				
				System.out.println("do you want to check another bug ?");
				System.out.println("1. yes");
				System.out.println("2. no");
				int re = sc.nextInt();

				if (re == 2) {
					System.out.println("ok closing ....");
					bug++;

				} // if
			} // while

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			

		}

		case 2: {

			System.out.println("thanks for using AUTOMATED BUG REVIEW TOOL ");
			System.out.println("byeee ");

		}
			break;

		default:
			System.out.println("error");

		}

	}

	public String ReadCellData(int vRow, int vColumn) {
		String value = null; // variable for storing the cell value
		Workbook wb = null; // initialize Workbook null
		try {
			// reading data from a file in the form of bytes
			FileInputStream fis = new FileInputStream("D:\\\\BITS PROJE\\\\bugs.xlsx");
			// constructs an XSSFWorkbook object, by buffering the whole stream into the
			// memory
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Sheet sheet = wb.getSheetAt(0); // getting the XSSFSheet object at given index
		Row row = sheet.getRow(vRow); // returns the logical row
		Cell cell = row.getCell(vColumn); // getting the cell representing the given column
		value = cell.getStringCellValue(); // getting cell value

		return value; // returns the cell value
	}
}