package BFS;

import java.util.*;
import java.lang.*;
import java.io.*;

class DistanceCalculator
{
	public static void main (String[] args) throws java.lang.Exception
	{	
		BufferedReader in = new BufferedReader(new FileReader("/Users/chelseaw/Documents/workspace/Algo_v1/data/dist.csv"));
        String line = "";
        while ((line = in.readLine()) != null) {
        	
            String parts[] = line.split(",");
            double lat1 = Double.parseDouble(parts[0]);
            double lon1 = Double.parseDouble(parts[1]);
            double lat2 = Double.parseDouble(parts[2]);
            double lon2 = Double.parseDouble(parts[3]);
            System.out.println(distance(lat1,lon1,lat2,lon2, "K") + "km");
        }
        in.close();       
		
		//System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "M") + " Miles\n");
		
		//System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "N") + " Nautical Miles\n");
	}

	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == "K") {
			dist = dist * 1.609344;
		} else if (unit == "N") {
			dist = dist * 0.8684;
		}

		return (dist);
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts decimal degrees to radians						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts radians to decimal degrees						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}
