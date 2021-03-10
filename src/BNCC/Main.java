package BNCC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main 
{
	//karyawan
	ArrayList<Karyawan>arrlist=new ArrayList<Karyawan>();
	//jenis jabatan
	ArrayList<String>ML = new ArrayList<String>();
	ArrayList<String>SL = new ArrayList<String>();
	ArrayList<String>AL = new ArrayList<String>();
	ArrayList<String>penampung_ID = new ArrayList<String>();
	ArrayList<Double>penampung_gaji = new ArrayList<Double>();
	ArrayList<String>penampung_jab = new ArrayList<String>();
	//=========================================
	Scanner scan = new Scanner(System.in);
	Random rand = new Random(); 

	public Main()
	{
		int Pilihan = 0;
		do {	
			System.out.println("Selamat Datang Di PT.Menthol Jaya");
			System.out.println("1. Add Data Karyawan");
			System.out.println("2. Update Data Karyawan");
			System.out.println("3. Delete Data");
			System.out.println("4. View Karyawan");
			System.out.println("5. Exit");
			
			Pilihan = scan.nextInt();scan.nextLine();
			switch(Pilihan)
			{
			// case pertama ================================================================
			case 1 ://inser(inputan)
				//alphabet random generator	
				String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				String randomString = "";
				int lenght = 2;
				char[] text = new char[lenght];
				
				// numeric random generator			
				int angka_random = 9999;
				int AccountNum ;
				String ID = "";
				// inputan karyawan
				String nama;
				String jenis_kelamin;
				String jabatan;
				double gaji = 0.0;
				//---------------
				String cek;
//				int temporary= 0;
//				random char	
				for(int i = 0 ; i < lenght ; i++)
				{
					text[i] = characters.charAt(rand.nextInt(characters.length()));
				}
				for(int i = 0 ; i < text.length ; i++)
				{
					randomString += text[i];
				}
				// random numeric
				AccountNum = rand.nextInt(angka_random);
				String s = "" + AccountNum;
				ID = randomString.concat("-").concat(s);
				//input nama=====================================================================================
				do
				{
				System.out.println("Masukan Nama Lengkap Anda:");
				nama = scan.nextLine();
				}while(nama.length() <= 3);
				//==============================================================================================
				do
				{
					System.out.println("Masukan jenis kelamin anda [Laki-Laki || Perempuan] : ");
					System.out.println("kata kata harus sama !!!");
					jenis_kelamin = scan.nextLine();
				}while(!jenis_kelamin.contentEquals("Laki-Laki") && !jenis_kelamin.contentEquals("Perempuan"));
				//==============================================================================================
				do
				{
					System.out.println("Masukan Jabatan Anda [ Manager / Supervisor / Admin ]");
					System.out.println("kata kata harus sama !!!");
					jabatan = scan.nextLine();
				}while(!jabatan.contentEquals("Manager") && !jabatan.contentEquals("Supervisor") && !jabatan.contentEquals("Admin"));
				//==============================================================================================
				do 
				{
					System.out.println("anda yakin ingin menyimpan data ini [YES||NO]");
					cek=scan.nextLine();
				} while (!cek.contentEquals("YES")&&!cek.contentEquals("NO"));
				if(cek.contentEquals("NO")) 
				{
					break;
				}
				System.out.println("Berhasil Menambahkan Data Karyawan Dengan ID " + ID);
				//gaji=======================================================
				penampung_ID.add(ID);
				if(jabatan.equals("Admin"))
				{
					gaji = 4000000;
					AL.add(ID);
				}
				else if (jabatan.equals("Supervisor"))
				{
					gaji = 6000000;
					SL.add(ID);
				}
				else if (jabatan.equals("Manager"))
				{
					gaji = 8000000;
					ML.add(ID);
				}
//--------------------------------------------------------				
				penampung_gaji.add(gaji);		//
				penampung_jab.add(jabatan);		//
//bonus gaji Admin =======================================================================================
				if(AL.size() > 3 )
				{
					if(jabatan.equals("Admin"))
						{
							String id = "Bonus Sebesar 5% telah diberikan kepada Karyawan dengan ID" ;
							for(int i = 0 ; i < penampung_gaji.size() -1  ; i++)
							{
								if(penampung_jab.get(i).equals("Admin"))
								{
									id = id + " ," + penampung_ID.get(i);
								}
								
							}
							
							System.out.println(id);
							
							if(AL.size() % 3 == 0)
							{
								for(int i = 0; i < AL.size()-1; i++)
								{
									penampung_gaji.set(i, (penampung_gaji.get(i) + (gaji * 1 / 20)));
								}
							}
							
						}			
				
				}
//=======================================================================================================================				
// bonus gaji supervisor
				if(SL.size() > 3 )
				{
					if(jabatan.equals("Supervisor"))
						{
							String id = "Bonus Sebesar 7.5% telah diberikan kepada Karyawan dengan ID" ;
							for(int i = 0 ; i < penampung_gaji.size() -1  ; i++)
							{
								if(penampung_jab.get(i).equals("Supervisor"))
								{
									id = id + " ," + penampung_ID.get(i);
								}
								
							}
							
							System.out.println(id);
							
							if(SL.size() % 3 == 0)
							{
								for(int i = 0; i < SL.size()-1; i++)
								{
									penampung_gaji.set(i, (penampung_gaji.get(i) + (gaji * 3 / 40)));
								}
							}
							
						}			
				
				}
//======================================================================================================================				
// bonus gaji Manager
				if(ML.size() > 3 )
				{
					if(jabatan.equals("Manager"))
						{
							String id = "Bonus Sebesar 10% telah diberikan kepada Karyawan dengan ID" ;
							for(int i = 0 ; i < penampung_gaji.size() -1  ; i++)
							{
								if(penampung_jab.get(i).equals("Manager"))
								{
									id = id + " ," + penampung_ID.get(i);
								}
								
							}
							
							System.out.println(id);
							
							if(ML.size() % 3 == 0)
							{
								for(int i = 0; i < ML.size()-1; i++)
								{
									penampung_gaji.set(i, (penampung_gaji.get(i) + (gaji * 1 / 10)));
								}
							}	
						}			
					
				}
//======================================================================================================================				
	
				arrlist.add(new Karyawan(nama, jenis_kelamin,jabatan,gaji,ID));
//comparatoe========================================================================================				
				Collections.sort(arrlist,new Sortnama());
//--------------------------------------------------------------------------------------------------
				break;
				
//========================================================================================================				
			case 2://update--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
				if(arrlist.isEmpty())
				{
					System.out.println("Maaf,Data Tidak Tersedia\n");
				}
				else
				{
					int ind = 0;
					int wow = 0;
					int deleted;
					System.out.println("|||=======||==================||============================||========================||=================||===================|||");
					System.out.println("||| NO    ||  KODE KARYAWAN   ||	    NAMA KARYAWAN   ||	 JENIS KELAMIN	      ||	JABATAN	 ||  Gaji Karyawan    |||");
					System.out.println("|||=======||==================||============================||========================||=================||===================|||");
					for(Karyawan karyawan : arrlist)
					{
					System.out.printf("|||  %3s  || %2s          || %2s                      || %2s              || %2s         || Rp.%2.2f    |||\n",(ind + 1),karyawan.getID(),karyawan.getnama(),karyawan.getJenis_kelamin(),karyawan.getJabatan(),karyawan.getGaji());
					++ind;
					}
					System.out.println("Pilih Data Yang Ingin DI Update : ");
					deleted = scan.nextInt();scan.nextLine();
					arrlist.remove(deleted-1);
					
				//========================insert new=============================================================================================================================
					do
					{
					System.out.println("Masukan Nama Lengkap Anda:");
					nama = scan.nextLine();
					}while(nama.length() <= 3);
					//==============================================================================================
					do
					{
						System.out.println("Masukan jenis kelamin anda [Laki-Laki || Perempuan] : ");
						System.out.println("kata kata harus sama !!!");
						jenis_kelamin = scan.nextLine();
					}while(!jenis_kelamin.contentEquals("Laki-Laki") && !jenis_kelamin.contentEquals("Perempuan"));
					//==============================================================================================
					do
					{
						System.out.println("Masukan Jabatan Anda [ Manager / Supervisor / Admin ]");
						System.out.println("kata kata harus sama !!!");
						jabatan = scan.nextLine();
					}while(!jabatan.contentEquals("Manager") && !jabatan.contentEquals("Supervisor") && !jabatan.contentEquals("Admin"));
					//==============================================================================================
					do 
					{
						System.out.println("anda yakin ingin menyimpan data ini [YES||NO]");
						cek=scan.nextLine();
					} while (!cek.contentEquals("YES")&&!cek.contentEquals("NO"));
					if(cek.contentEquals("NO")) 
					{
						break;
					}
					
					System.out.println("|||=======||==================||============================||========================||=================||===================|||");
					System.out.println("||| NO    ||  KODE KARYAWAN   ||	    NAMA KARYAWAN   ||	 JENIS KELAMIN	      ||	JABATAN	 ||  Gaji Karyawan    |||");
					System.out.println("|||=======||==================||============================||========================||=================||===================|||");
					for(Karyawan karyawan : arrlist)
					{
					System.out.printf("|||  %3s  || %2s          || %2s                      || %2s              || %2s         || Rp.%2.2f    |||\n",(wow + 1),karyawan.getID(),karyawan.getnama(),karyawan.getJenis_kelamin(),karyawan.getJabatan(),karyawan.getGaji());
					++wow;
					}
			
				}
				
				break;
//==================================================================================================================================================================================================================================================================================			
			case 3://delete--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
				if(arrlist.isEmpty())
				{
					System.out.println("Maaf,Data Tidak Tersedia\n");
				}
				else
				{
					int ind = 0;
					int wow = 0;
					int deleted;
					System.out.println("|||=======||==================||============================||========================||=================||===================|||");
					System.out.println("||| NO    ||  KODE KARYAWAN   ||	    NAMA KARYAWAN   ||	 JENIS KELAMIN	      ||	JABATAN	 ||  Gaji Karyawan    |||");
					System.out.println("|||=======||==================||============================||========================||=================||===================|||");
					for(Karyawan karyawan : arrlist)
					{
					System.out.printf("|||  %3s  || %2s          || %2s                      || %2s              || %2s         || Rp.%2.2f    |||\n",(ind + 1),karyawan.getID(),karyawan.getnama(),karyawan.getJenis_kelamin(),karyawan.getJabatan(),karyawan.getGaji());
					++ind;
					}
					System.out.println("Pilih Data Yang Ingin DI Hapus : ");
					deleted = scan.nextInt();scan.nextLine();
					arrlist.remove(deleted-1);
					System.out.println("deleted success");
					System.out.println("|||=======||==================||============================||========================||=================||===================|||");
					System.out.println("||| NO    ||  KODE KARYAWAN   ||	    NAMA KARYAWAN   ||	 JENIS KELAMIN	      ||	JABATAN	 ||  Gaji Karyawan    |||");
					System.out.println("|||=======||==================||============================||========================||=================||===================|||");
					for(Karyawan karyawan : arrlist)
					{
					System.out.printf("|||  %3s  || %2s          || %2s                      || %2s              || %2s         || Rp.%2.2f    |||\n",(wow + 1),karyawan.getID(),karyawan.getnama(),karyawan.getJenis_kelamin(),karyawan.getJabatan(),karyawan.getGaji());
					++wow;
					}
				}
				break;
				
			case 4://view----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			
				int ind = 0;
				if(arrlist.isEmpty())
				{
					System.out.println("Maaf,Data Tidak Tersedia\n");
				}
				else
				{
					System.out.println("|||=======||==================||============================||========================||=================||===================|||");
					System.out.println("||| NO    ||  KODE KARYAWAN   ||	    NAMA KARYAWAN   ||	 JENIS KELAMIN	      ||	JABATAN	 ||  Gaji Karyawan    |||");
					System.out.println("|||=======||==================||============================||========================||=================||===================|||");
					for(Karyawan karyawan : arrlist)
					{
					System.out.printf("|||  %3s  || %2s          || %2s                      || %2s              || %2s         || Rp.%2.2f    |||\n",(ind + 1),karyawan.getID(),karyawan.getnama(),karyawan.getJenis_kelamin(),karyawan.getJabatan(),karyawan.getGaji());
					++ind;
					}
				}
			break;
		
			case 5://exit
				System.out.println("Terima Kasih");
				System.exit(0);
				
			default :
				System.out.println("maaf nomor tidak match,silahkan masukan nomor yang tepat\n");
				
			}
			
		   } while (Pilihan!=5);
		
		
	}

	public static void main(String[] args) 
	{
		new Main();
	}

}
