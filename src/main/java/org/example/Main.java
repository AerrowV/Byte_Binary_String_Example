package org.example;

public class Main {
    public static void main(String[] args) {
        String message = "Yooooo";
        byte[] byteArray = convertStringToByteArray(message);
        String bitString = convertByteArrayToBitString(byteArray);
        /* Converter fra bitstreng tilbage til bytearray */
        byte[] newByteArray = convertBitStringToByteArray(bitString);
        String deSerializedString = convertByteArrayToString(newByteArray);
        System.out.println(deSerializedString);
    }

    private static String convertByteArrayToString(byte[] byteArray) {
        return new String(byteArray);
    }

    private static byte[] convertBitStringToByteArray(String bitString) {
        int numberOfBytes = bitString.length() / 8;
        byte[] byteArray = new byte[numberOfBytes];

        for (int i = 0; i < numberOfBytes; i++) {
            int index = i * 8;
            String byteBits = bitString.substring(index, index + 8);
            byteArray[i] = (byte) Integer.parseInt(byteBits, 2);
        }
        return byteArray;
    }

    private static String convertByteArrayToBitString(byte[] byteArray) {

        StringBuilder binaryString = new StringBuilder();
        for (byte b : byteArray) {
            String binaryRepresentation = "";
            int value = b;
            /* Convert byte to string */
            for (int i = 0; i < 8; i++) {
                binaryRepresentation = (value % 2) + binaryRepresentation;
                value = value / 2;
            }
            binaryString.append(binaryRepresentation);
        }
        return binaryString.toString();
    }

    private static byte[] convertStringToByteArray(String message) {

        if (message != null)
            return message.getBytes();

        return new byte[0];

    }
}