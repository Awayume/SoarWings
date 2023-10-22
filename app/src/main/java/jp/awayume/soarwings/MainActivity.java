// SPDX-FileCopyrightText: 2023 Awayume <dev@awayume.jp>
// SPDX-License-Identifier: Apache-2.0

package jp.awayume.soarwings;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import jp.awayume.soarwings.apksigner.ApkSigner;
import jp.awayume.soarwings.apksigner.ApkSignerException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}