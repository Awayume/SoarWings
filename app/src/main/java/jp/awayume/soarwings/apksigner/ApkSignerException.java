// SPDX-FileCopyrightText: 2023 Awayume <dev@awayume.jp>
// SPDX-License-Identifier: Apache-2.0

package jp.awayume.soarwings.apksigner;


/**
 * A class to wrap apksigner.jar exception.
 *
 * @author Awayume <dev@awayume.jp>
 * @since 0.1.0
 */
public class ApkSignerException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new `ApkSignerException` instance from exception.
     *
     * @param cause The exception from apksigner.jar.
     */
    public ApkSignerException(Exception cause) {
        super(cause);
    }
}
