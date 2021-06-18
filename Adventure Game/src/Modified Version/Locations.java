package husleFolder14;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Locations implements Map<Integer,Location> {
	
	private static Map<Integer,Location> locations=new LinkedHashMap<Integer, Location>();

	public static void main(String[] args) throws IOException {
//		
//		try(BufferedWriter locFile=new BufferedWriter(new FileWriter("locations.txt"));
//			BufferedWriter dirFile=new BufferedWriter(new FileWriter("directions.txt"))){
//			for(Location location:locations.values()) {
//				locFile.write(location.getLocationID()+","+location.getDescription()+"\n");
//				for(String direction:location.getExits().keySet()) {
//					if(!direction.equalsIgnoreCase("Q")) {
//						dirFile.write(location.getLocationID()+","+direction+","+location.getExits().get(direction)+"\n");
//					}
//				}
//			}
		try (DataOutputStream locFile=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.txt")))){
			for(Location location:locations.values()) {
				locFile.write(location.getLocationID());
				locFile.writeUTF(location.getDescription());
				System.out.println("Writing location "+location.getLocationID()+" : "+location.getDescription());
				System.out.println("Writing "+(location.getExits().size()-1)+"exits");
				locFile.writeInt(location.getExits().size()-1);
				for(String direction:location.getExits().keySet()) {
					if(!direction.equalsIgnoreCase("Q")) {
						System.out.println("\t\t"+direction+location.getExits().get(direction));
						locFile.writeUTF(direction);
						locFile.writeInt(location.getExits().get(direction));
					}
				}
			}
		
		}
//		FileWriter locFile=null;
//		try {
//			locFile=new FileWriter("locations.txt");
//			for(Location location:locations.values()) {
//				locFile.write(location.getLocationID()+","+location.getDescription()+"\n");
//			}
//		}
//		finally {
//			System.out.println("Finally block executed");
//			if(locFile!=null) {
//				System.out.println("Attempting to close locFile");
//				locFile.close();
//			}
//		}
	}
	
	static {
		
		try(Scanner scanner=new Scanner(new BufferedReader(new FileReader("locations_big.txt")))) {
			scanner.useDelimiter(",");
			while(scanner.hasNextLine()) {
				int loc=scanner.nextInt();
				scanner.skip(scanner.delimiter());
				String description=scanner.nextLine();
				System.out.println("Imported loc: "+loc+":"+description);
				Map<String,Integer> tempExit=new HashMap<String,Integer>();
				locations.put(loc,new Location(loc,description,tempExit));
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		//Now adding the exits
		try(BufferedReader dirFile=new BufferedReader(new FileReader("directions_big.txt"))) {
			String input;
			while((input=dirFile.readLine())!=null) {
//				int loc=scanner.nextInt();
//				scanner.skip(scanner.delimiter());
//				String direction=scanner.next();
//				scanner.skip(scanner.delimiter());
//				String des=scanner.nextLine();
//				int destination=Integer.parseInt(des);
				String []data=input.split(",");
				int loc=Integer.parseInt(data[0]);
				String direction=data[1];
				int destination=Integer.parseInt(data[2]);
				System.out.println(loc+" : "+direction+" : "+destination);
				Location location=locations.get(loc);
				location.addExit(direction,destination);
			}
		}catch(IOException e) {
				e.printStackTrace();
		}
		finally {
			
		}		
		
		
		
//		Map<String,Integer> tempExit=new HashMap<String, Integer>();
//		
//		locations.put(0,new Location(0,"You are sitting in front of a computer learning Java",tempExit));
//		
//		tempExit=new HashMap<String, Integer>();
//		tempExit.put("W",2);
//		tempExit.put("E",3);
//		tempExit.put("S",4);
//		tempExit.put("N",5);
//		locations.put(1,new Location(1,"You are sitting at the end of the road before a small brick building",tempExit));
//
//		tempExit=new HashMap<String, Integer>();
//		tempExit.put("N",5);		
//		locations.put(2,new Location(2,"You are at the top of a hill",tempExit));
//		
//		tempExit=new HashMap<String, Integer>();
//		tempExit.put("W",1);
//		locations.put(3,new Location(3,"You are inside a building, a well house for a spring",tempExit));
//		
//		tempExit=new HashMap<String, Integer>();
//		tempExit.put("N",1);
//		tempExit.put("W",2);
//		locations.put(5,new Location(5,"You are in the forest",tempExit));
//		
//		tempExit=new HashMap<String, Integer>();
//		tempExit.put("S",1);
//		tempExit.put("W",2);
//		locations.put(4,new Location(4,"You are in the valley beside the stream",tempExit));
	}
	
	@Override
	public int size() {
		return locations.size();
	}

	@Override
	public boolean isEmpty() {
		return locations.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return locations.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return locations.containsValue(value);
	}

	@Override
	public Location get(Object key) {
		return locations.get(key);
	}

	@Override
	public Location put(Integer key, Location value) {
		return locations.put(key, value);
	}

	@Override
	public Location remove(Object key) {
		return locations.remove(key);
	}

	@Override
	public void putAll(Map<? extends Integer, ? extends Location> m) {
		
		
	}

	@Override
	public void clear() {
		locations.clear();
		
	}

	@Override
	public Set<Integer> keySet() {
		return locations.keySet();
	}

	@Override
	public Collection<Location> values() {
		return locations.values();
	}

	@Override
	public Set<Entry<Integer, Location>> entrySet() {
		return locations.entrySet();
	}
	
	
}
