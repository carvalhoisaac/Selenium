package dtvm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import utils.Utils;

public class UtilsDiasUteis {
	private static String fileDiasUteis = "C:\\App\\Conf\\DiasUteis.txt";
	private static SimpleDateFormat sdff = new SimpleDateFormat("yyyyMMdd");
	private static HashMap<String, Date> diasUteis = new HashMap<String, Date>();
	public static Date nnumberdate = null;
	public static String DateFormat = null;

	public static void main(String[] args) {
		loadDiasUteis();
		ArrayList<Date> datasDiasUteis = listDiasUteis(Calendar.getInstance().getTime(), 60);
	
	}

	public static void loadDiasUteis() {
		ArrayList<String> lines = Utils.readLinesInFile(fileDiasUteis);
		System.out.println("Loading working days!");
		for (String line : lines) {
			if (line.startsWith("#")) {
				continue;
			}
			String[] fields = line.split(",");
			if (fields.length > 0) {  
				Date diaUtil = null;
				try {
					diaUtil = sdff.parse(fields[0]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if (diaUtil != null) {
					diasUteis.put(fields[0], diaUtil);
					// System.out.print(fields[0]+ " ");
				}

			}
		}

		System.out.println();

	}

	public static boolean isDiaUtil(Date dataTeste) {
		String keyDate = sdff.format(dataTeste);
		if (diasUteis.get(keyDate) != null) {
			return true;
		} else {
			return false;
		}
	}

	public static ArrayList<Date> listDiasUteis(Date dataFinal, int nDays) {
		ArrayList<Date> datas = new ArrayList<Date>();

		int numberDate = Integer.parseInt(sdff.format(dataFinal));

		String keyDate = Integer.toString(numberDate);
		int iDays = 0;
		while (iDays < nDays) {
			if (diasUteis.get(keyDate) != null) {
				datas.add(diasUteis.get(keyDate));
				iDays++;
			}
			numberDate = numberDate - 1;
			keyDate = Integer.toString(numberDate);
		}

		for (Date dataUtil : datas) {
			System.out.println(dataUtil);
		}

		nnumberdate = datas.get(datas.size() - 1);
		DateFormat dt = new SimpleDateFormat("dd/mm/yyyy");
		DateFormat = dt.format(UtilsDiasUteis.nnumberdate);
		System.out.println("Essa é a DataF: " + DateFormat);

		return datas;
    
		
			
			
		}
	
	
	
	}

	
		
	


