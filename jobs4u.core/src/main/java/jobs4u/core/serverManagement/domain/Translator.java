package jobs4u.core.serverManagement.domain;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.List;

/**
 * The type Translator.
 */
public class Translator {

    /**
     * Encode byte [ ].
     *
     * @param version the version
     * @param code    the code
     * @param data1   the data 1
     * @param data2   the data 2
     * @return the byte [ ]
     */
    public static byte[] encode(int version, MessageCode code, byte[] data1, byte[] data2) {
        int data1Len = (data1 != null) ? data1.length : 0;
        int data2Len = (data2 != null) ? data2.length : 0;

        int totalLength = 4; // VERSION (1 byte) + CODE (1 byte) + DATA1_LEN_L (1 byte) + DATA1_LEN_M (1 byte)
        if (data1Len > 0) totalLength += data1Len;
        if (data1Len > 0 && data2Len > 0) totalLength += 2; // DATA2_LEN_L (1 byte) + DATA2_LEN_M (1 byte)
        if (data2Len > 0) totalLength += data2Len;

        ByteBuffer buffer = ByteBuffer.allocate(totalLength);
        buffer.put((byte) version);
        buffer.put((byte) code.getCode());

        if (data1Len > 0) {
            buffer.put((byte) (data1Len % 256)); // DATA1_LEN_L
            buffer.put((byte) (data1Len / 256)); // DATA1_LEN_M
            buffer.put(data1);
        } else {
            buffer.put((byte) 0);
            buffer.put((byte) 0);
        }

        if (data2Len > 0) {
            buffer.put((byte) (data2Len % 256)); // DATA2_LEN_L
            buffer.put((byte) (data2Len / 256)); // DATA2_LEN_M
            buffer.put(data2);
        }

        return buffer.array();
    }


    /**
     * Decode version int.
     *
     * @param encodedMessage the encoded message
     * @return the int
     */
    public static int decodeVersion(byte[] encodedMessage) {
        ByteBuffer buffer = ByteBuffer.wrap(encodedMessage);
        return Byte.toUnsignedInt(buffer.get(0));
    }

    /**
     * Decode code int.
     *
     * @param encodedMessage the encoded message
     * @return the int
     */
    public static int decodeCode(byte[] encodedMessage) {
        ByteBuffer buffer = ByteBuffer.wrap(encodedMessage);
        return Byte.toUnsignedInt(buffer.get(1));
    }

    /**
     * Decode data 1 len int.
     *
     * @param encodedMessage the encoded message
     * @return the int
     */
    public static int decodeData1Len(byte[] encodedMessage) {
        ByteBuffer buffer = ByteBuffer.wrap(encodedMessage);
        int data1LenL = Byte.toUnsignedInt(buffer.get(2));
        int data1LenM = Byte.toUnsignedInt(buffer.get(3));
        return data1LenL + (256 * data1LenM);
    }

    /**
     * Decode data 1 byte [ ].
     *
     * @param encodedMessage the encoded message
     * @return the byte [ ]
     */
    public static byte[] decodeData1(byte[] encodedMessage) {
        int data1Len = decodeData1Len(encodedMessage);
        if (data1Len == 0) {
            return null;
        }
        ByteBuffer buffer = ByteBuffer.wrap(encodedMessage);
        byte[] data1 = new byte[data1Len];
        buffer.position(4); // Skip to the start of DATA1
        buffer.get(data1, 0, data1Len);
        return data1;
    }

    /**
     * Decode data 2 len int.
     *
     * @param encodedMessage the encoded message
     * @return the int
     */
    public static int decodeData2Len(byte[] encodedMessage) {
        int data1Len = decodeData1Len(encodedMessage);
        if (data1Len == 0 || encodedMessage.length < 6 + data1Len) {
            return 0;
        }
        ByteBuffer buffer = ByteBuffer.wrap(encodedMessage);
        int data2LenL = Byte.toUnsignedInt(buffer.get(4 + data1Len));
        int data2LenM = Byte.toUnsignedInt(buffer.get(5 + data1Len));
        return data2LenL + (256 * data2LenM);
    }

    /**
     * Decode data 2 byte [ ].
     *
     * @param encodedMessage the encoded message
     * @return the byte [ ]
     */
    public static byte[] decodeData2(byte[] encodedMessage) {
        int data1Len = decodeData1Len(encodedMessage);
        int data2Len = decodeData2Len(encodedMessage);
        if (data2Len == 0) {
            return null;
        }
        ByteBuffer buffer = ByteBuffer.wrap(encodedMessage);
        byte[] data2 = new byte[data2Len];
        buffer.position(6 + data1Len); // Skip to the start of DATA2
        buffer.get(data2, 0, data2Len);
        return data2;
    }

    /**
     * Serialize list job openings byte [ ].
     *
     * @param list the list
     * @return the byte [ ]
     * @throws IOException the io exception
     */
    public static byte[] serializeListJobOpenings(List<String> list) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(list);
            return bos.toByteArray();
        }
    }

    /**
     * Deserialize list job openings list.
     *
     * @param bytes the bytes
     * @return the list
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static List<String> deserializeListJobOpenings(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             ObjectInputStream in = new ObjectInputStream(bis)) {
            return (List<String>) in.readObject();
        }
    }

    /**
     * Serialize list job applications byte [ ].
     *
     * @param list the list
     * @return the byte [ ]
     * @throws IOException the io exception
     */
    public static byte[] serializeListJobApplications(List<String> list) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(list);
            return bos.toByteArray();
        }
    }

    /**
     * Deserialize list job applications list.
     *
     * @param bytes the bytes
     * @return the list
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static List<String> deserializeListJobApplications(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             ObjectInputStream in = new ObjectInputStream(bis)) {
            return (List<String>) in.readObject();
        }
    }

    /**
     * Serialize notification job application byte [ ].
     *
     * @param list the list
     * @return the byte [ ]
     * @throws IOException the io exception
     */
    public static byte[] serializeNotificationJobApplication(List<String> list) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(list);
            return bos.toByteArray();
        }
    }

    /**
     * Deserialize notification job application list.
     *
     * @param bytes the bytes
     * @return the list
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static List<String> deserializeNotificationJobApplication(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             ObjectInputStream in = new ObjectInputStream(bis)) {
            return (List<String>) in.readObject();
        }
    }
}