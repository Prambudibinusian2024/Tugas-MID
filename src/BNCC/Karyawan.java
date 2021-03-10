package BNCC;

public class Karyawan 
{
	private String nama;
	private String jenis_kelamin;
	private String jabatan;
	private double gaji = 0.0 ;
	private String ID;
	
	public Karyawan(String nama, String jenis_kelamin, String jabatan,double gaji,String ID) 
	{
		this.nama = nama;
		this.jenis_kelamin = jenis_kelamin;
		this.jabatan = jabatan;
		this.gaji = gaji;
		this.ID = ID;
	}

	public String getnama() {
		return nama;
	}

	public void setNamaKaryawan(String nama) {
		this.nama = nama;
	}

	public String getJenis_kelamin() {
		return jenis_kelamin;
	}

	public void setJenis_kelamin(String jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}

	public String getJabatan() {
		return jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	public double getGaji() {
		return gaji;
	}

	public void setGaji(double gaji) {
		this.gaji = gaji;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}


	
}
