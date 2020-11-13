import java.util.*;
public class Leaky
{
	public static void main(String[] args)
	{	
		int bucket_size;
		int flow_rate;
		int iteration;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the bucket size: ");
		bucket_size = scan.nextInt();
		
		System.out.print("Enter flow rate: ");
		flow_rate = scan.nextInt();
		
		System.out.print("Enter number of iterations: ");
		iteration = scan.nextInt();
		
		int packets[] = new int[iteration];
		
		for(int i=1; i<=iteration; i++)
		{
			System.out.print("Enter number of packets for iteration" +i+ ": ");
			packets[i-1] = scan.nextInt();
		}
		
		System.out.println("___________________________________________________________________________________________________________");
		System.out.println("| Iteration No. | Packet per Iteration  | Bucket content | Packet Sent  | Packet left out| Packet dropped |");
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		
		int bucket_content = 0;
		int i = 1;
		int j;
		int packet_dropped, packet_sent, packet_left_out;
		int packets_per_iteration;
		
		do
		{	
			packet_dropped = 0;
			
			if(i <= iteration) {
				packets_per_iteration = packets[i-1];
				bucket_content = bucket_content + packets[i-1];
				j = i;
			}
			else {
				packets_per_iteration = 0;
				j = 0;
			}
	
			if (bucket_content > bucket_size) {
				packet_dropped = bucket_content - bucket_size;
				bucket_content = bucket_size;
			}
			
			if(bucket_content>=flow_rate) {
				packet_sent = flow_rate;
				packet_left_out = bucket_content - flow_rate;
			}
			else {
				packet_sent = bucket_content;
				packet_left_out = 0;
			}
			
			System.out.println("|\t"+j +"\t|\t " +packets_per_iteration + "\t\t|\t"+ bucket_content + "\t|\t " +packet_sent + "\t|\t"+packet_left_out + " \t|\t" +packet_dropped+"\t  |");
			
			i++;
			bucket_content = packet_left_out;
		}while((bucket_content != 0) | i<=iteration);
		
	}
}