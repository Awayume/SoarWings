// SPDX-FileCopyrightText: 2023 Awayume <dev@awayume.jp>
// SPDX-License-Identifier: Apache-2.0

package jp.awayume.soarwings.apksigner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.android.apksigner.ApkSignerTool;


/**
 * A class to make command line arguments.
 *
 * @author Awayume <dev@awayume.jp>
 * @since 0.1.0
 */
class ArgumentsBuilder {
    private final List<String> args;

    /**
     * Creates a new `ArgumentsBuilder` instance.
     */
    public ArgumentsBuilder() {
        this.args = new ArrayList<>();
    }

    /**
     * Adds an additional argument.
     *
     * @param arg An additional argument.
     */
    public void add(String arg) {
        this.args.add(arg);
    }

    /**
     * Convert to be usable as command line arguments.
     * @return The command line arguments.
     */
    public String[] toArray() {
        String[] args = new String[this.args.size()];
        this.args.toArray(args);
        return args;
    }
}


/**
 * A class for signing APK.
 *
 * This class uses apksigner.jar by Google internally.
 *
 * @author Awayume <dev@awayume.jp>
 * @since 0.1.0
 */
public class ApkSigner {
    /**
     * Executes apksigner.jar.
     *
     * @param args Command line arguments to be passed to apksigner.jar
     * @return Outputs from apksigner.jar
     * @throws ApkSignerException apksigner.jar terminated with some error.
     */
    private static String execute(String[] args) throws ApkSignerException {
        PrintStream stdout = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        System.setOut(ps);
        try {
            ApkSignerTool.main(args);
        } catch (Exception e) {
            throw new ApkSignerException(e);
        } finally {
            System.setOut(stdout);
        }
        return bos.toString();
    }

    /**
     * Creates a lineage to rotate signing keys.
     *
     * @param out The path to output lineage.
     * @param old_ks The old Java keystore path.
     * @param new_ks The new Java keystore path.
     * @return Command outputs.
     * @throws ApkSignerException Something went wrong.
     */
    public static String rotate(Path out, Path old_ks, Path new_ks) throws ApkSignerException {
        ArgumentsBuilder args = new ArgumentsBuilder();
        args.add("rotate");
        args.add("--out");
        args.add(out.toString());
        args.add("--old-signer");
        args.add(old_ks.toString());
        args.add("--new-signer");
        args.add(new_ks.toString());
        return ApkSigner.execute(args.toArray());
    }

    /**
     * Creates a new lineage to rotate signing keys from an old lineage.
     *
     * @param in The old lineage path.
     * @param out The path to output new lineage.
     * @param old_ks The old Java keystore path.
     * @param new_ks The new Java keystore path.
     * @return Command outputs.
     * @throws ApkSignerException Something went wrong.
     */
    public static String rotate(Path in, Path out, Path old_ks, Path new_ks) throws ApkSignerException {
        ArgumentsBuilder args = new ArgumentsBuilder();
        args.add("rotate");
        args.add("--in");
        args.add(in.toString());
        args.add("--out");
        args.add(out.toString());
        args.add("--old-signer");
        args.add(old_ks.toString());
        args.add("--new-signer");
        args.add(new_ks.toString());
        return ApkSigner.execute(args.toArray());
    }

    /**
     * Signs the APK.
     *
     * @param ks The Java keystore path.
     * @param apk The APK path.
     * @return Command outputs.
     * @throws ApkSignerException Something went wrong.
     */
    public static String sign(Path ks, Path apk) throws ApkSignerException {
        ArgumentsBuilder args = new ArgumentsBuilder();
        args.add("sign");
        args.add("--ks");
        args.add(ks.toString());
        args.add(apk.toString());
        return ApkSigner.execute(args.toArray());
    }

    /**
     * Signs APK with lineage.
     *
     * @param ks The Java keystore path.
     * @param lineage The lineage path.
     * @param apk The APK path.
     * @return Command outputs.
     * @throws ApkSignerException Something went wrong.
     */
    public static String sign(Path ks, Path lineage, Path apk) throws ApkSignerException {
        ArgumentsBuilder args = new ArgumentsBuilder();
        args.add("sign");
        args.add("--ks");
        args.add(ks.toString());
        args.add("--lineage");
        args.add(lineage.toString());
        args.add(apk.toString());
        return ApkSigner.execute(args.toArray());
    }

    /**
     * Gets apksigner.jar version.
     * @return apksigner.jar version.
     * @throws ApkSignerException Something went wrong.
     */
    public static String getVersion() throws ApkSignerException {
        ArgumentsBuilder args = new ArgumentsBuilder();
        args.add("version");
        return ApkSigner.execute(args.toArray());
    }
}