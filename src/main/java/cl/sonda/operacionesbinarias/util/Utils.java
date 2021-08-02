package cl.sonda.operacionesbinarias.util;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;

import cl.sonda.operacionesbinarias.exception.TablasReferenciasException;
import cl.sonda.operacionesbinarias.modelo.DataWS;

public class Utils {
	
	
	public static byte[] loadFileBin() {
	
			try {
				File file = new File(Constants.LOCATION_BIN);
				byte[] fileContent = Files.readAllBytes(file.toPath());
				return fileContent;
			} catch (IOException e) {
				throw new TablasReferenciasException("Error a leer el archivo: OperacionesBinarias.bin "+ e);
			}
	}


	/**
	 * Metodo que obtiene el numero en long de un arreglo de 7 bytes.
	 * 
	 * @param leido arreglo de byte leido con el numero de la tarjeta
	 * @return numero de tarjeta
	 * @throws TablasReferenciasException Arreglo debe ser de 7 bytes.
	 */
	public final long valor7bytesToInt(final byte[] leidoIn) throws TablasReferenciasException {
		byte[] leido = Utils.invertirCadena(leidoIn);
		final int largoValor = Constants.MAXIMO_BYTE_TARJETA;
		if (leido.length != largoValor) {
			throw new TablasReferenciasException("Arreglo debe ser de 7 bytes.");
		}
		final byte largoLong = 8;
		byte[] bytes = new byte[largoLong];
		final int indiceValor = 1;
		for (int i = 0; i < largoValor; i++) {
			bytes[indiceValor + i] = leido[0 + i];
		}
		ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
		buffer.put(bytes);
		buffer.flip(); // need flip
		return buffer.getLong();
	}

	/**
	 * Metodo que obtiene el numero en int de un arreglo de 2 bytes.
	 * 
	 * @param leido arreglo de byte leido con el numero de la tarjeta
	 * @return codigo de producto
	 * @throws TablasReferenciasException TablasReferenciasException
	 */
	public static int valor2bytesToInt(final byte[] leidoIn) throws TablasReferenciasException {
		byte[] leido = Utils.invertirCadena(leidoIn);
		final int largoValor = 2;
		if (leido.length != largoValor) {
			throw new TablasReferenciasException("Arreglo debe ser de 2 bytes.");
		}
		final byte largoInt = 4;
		byte[] bytes = new byte[largoInt];
		final int indiceValor = 2;
		bytes[indiceValor] = leido[0];
		bytes[indiceValor + 1] = leido[1];
		ByteBuffer byteBuffer = ByteBuffer.allocate(Integer.BYTES);
		byteBuffer.put(bytes);
		byteBuffer.flip();
		return byteBuffer.getInt();
	}

	/**
	 * Convierte un arreglo de bytes en un String con su correspondiente
	 * representacion hexadecimal.
	 * 
	 * @param bytes arreglo de bytes que se desea representar en hexadecimal.
	 * @return String con la representacion hexadecimal, cada par de caracteres se
	 *         retorna separado por espacios.
	 */
	public static String byteArrayToHexStringSinEspacios(final byte[] bytes) {
		
		final int desplazamiento = 4;
		
		char[] hexArray = "0123456789ABCDEF".toCharArray();
		char[] hexChars = new char[bytes.length * 2];
		
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & Constants.MASK_FF;
			hexChars[j * 2] = hexArray[v >>> desplazamiento];
			final int mascara = 0x0F;
			hexChars[j * 2 + 1] = hexArray[v & mascara];
		}
		return new String(hexChars);
	}

	public static byte[] invertirCadena(byte[] bytes) {

		return bytes;
	}

	public static DataWS loadOperation(DataWS dat) {
		 byte[] fileByte =loadFileBin();
		 
		 System.out.println("Largo Bytes : " + fileByte.length);
		// byte[] fileByte = new  byte[10];
//		for (int i = 0; i < fileByte.length; i++) {
//			System.out.println("Bytes "+ fileByte[i]);
//		}
		 
		 if(dat.getRegistryNumber()== null) {
			 throw new TablasReferenciasException("Error campo: registryNumber no puede ser null");
		 }
		 if(fileByte.length<1) {
			 throw new TablasReferenciasException("Error Arreglo Bytes poser largo menor a 1");
		 }
		 
		 dat.setBytesString(byteArrayToHexStringSinEspacios(fileByte));
		 
		return dat;
	}
}
