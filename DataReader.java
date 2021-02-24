import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
public class DataReader {

	public static void main(String[] args)throws IOException {
		List<String> bankAccount=Files.readAllLines(Paths.get("C:\\File\\bankaccount.txt"));
		List<String> bankTransaction=Files.readAllLines(Paths.get("C:\\File\\banktransactions.txt"));
		List<String> result=new ArrayList();
		result.add("Name,Age,Gender,Bank,CardNumber,TransactionDate,Amount");
		bankAccount.remove(0);
		bankTransaction.remove(0);
		for(String str:bankAccount) {
			String[] s=str.split(",");
			for(String str2:bankTransaction) {
				String[] s1=str2.split(",");
				if(Objects.equals(s[4],s1[0])) {
					  result.add(s[0]+"\t"+s[1]+"\t"+s[2]+"\t"+s[3]+"\t\t"+s[4]+"\t\t"+s1[1]+"\t\t"+s1[2]);
					
				}
			}
		}
		Files.write(Paths.get("C:\\File\\data.txt"),result);
		String string;
		Scanner scnr=new Scanner(System.in);
		System.out.println("Enter the name:");
		string=scnr.nextLine();
		Path path=Paths.get("C:\\File\\info.txt");
		 System.out.println("Name"+"\t"+"Age"+"\t"+"Gender"+"\t"+"Bank"+"\t"+"CardNumber"+"\t"+"TransactionDate"+"\t"+"Amount");
		Files.lines(path)
		.filter(str->str.contains(string))
		.forEach(System.out::println);
		

	}

}
