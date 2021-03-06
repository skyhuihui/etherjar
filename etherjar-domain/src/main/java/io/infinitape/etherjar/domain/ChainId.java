/*
 * Copyright (c) 2016-2017 Infinitape Inc, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.infinitape.etherjar.domain;

/**
 * CHAIN_ID for Replay Protection (EIP-155)
 */
public class ChainId {

    public static final ChainId MAINNET = new ChainId(61);
    public static final ChainId TESTNET = new ChainId(62);
    public static final ChainId EFNET = new ChainId(1);
    public static final ChainId ROPSTEN = new ChainId(3);

    private int value;

    public ChainId(int value) {
        if (!ChainId.isValid(value)) {
            throw new IllegalArgumentException("Invalid CHAIN_ID value: " + value);
        }
        this.value = value;
    }

    public static boolean isValid(int value) {
        return value >= 0 && value <= 255;
    }

    public int getValue() {
        return value;
    }

    public String toHex() {
        StringBuilder buf = new StringBuilder(4);
        buf.append("0x");
        if (value < 16) {
            buf.append('0');
        }
        buf.append(Integer.toHexString(value));
        return buf.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChainId)) return false;

        ChainId chainId = (ChainId) o;

        return value == chainId.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
