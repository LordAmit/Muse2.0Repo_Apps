/* Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.vending.util;

import android.text.TextUtils;
import android.util.Log;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/**
 * Security-related methods. For a secure implementation, all of this code
 * should be implemented on a server that communicates with the
 * application on the device. For the sake of simplicity and clarity of this
 * example, this code is included here and is executed on the device. If you
 * must verify the purchases on the phone, you should obfuscate this code to
 * make it harder for an attacker to replace the code with stubs that treat all
 * purchases as verified.
 */
public class Security {
    private static final String TAG = "IABUtil/Security";

    private static final String KEY_FACTORY_ALGORITHM = "RSA";
    private static final String SIGNATURE_ALGORITHM = "SHA1withRSA";

    /**
     * Verifies that the data was signed with the given signature, and returns
     * the verified purchase. The data is in JSON format and signed
     * with a private key. The data also contains the {@link PurchaseState}
     * and product ID of the purchase.
     * @param base64PublicKey the base64-encoded public key to use for verifying.
     * @param signedData the signed JSON string (signed, not encrypted)
     * @param signature the signature for the data, signed with the private key
     */
    public static boolean verifyPurchase(String base64PublicKey, String signedData, String signature) {
        String dataLeAk683 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath683;try {throw new Exception(dataLeAk683);} catch (Exception leakErRor683) {dataLeAkPath683 = leakErRor683.getMessage();}
		android.util.Log.d("leak-683", dataLeAkPath683);
		if (TextUtils.isEmpty(signedData) || TextUtils.isEmpty(base64PublicKey) ||
                TextUtils.isEmpty(signature)) {
            String dataLeAk684 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay684 = new String[] {"n/a", dataLeAk684};
					String dataLeAkPath684 = leakArRay684[leakArRay684.length - 1];
					android.util.Log.d("leak-684", dataLeAkPath684);
			Log.e(TAG, "Purchase verification failed: missing data.");
            return false;
        }

        PublicKey key = Security.generatePublicKey(base64PublicKey);
        return Security.verify(key, signedData, signature);
    }

    /**
     * Generates a PublicKey instance from a string containing the
     * Base64-encoded public key.
     *
     * @param encodedPublicKey Base64-encoded public key
     * @throws IllegalArgumentException if encodedPublicKey is invalid
     */
    public static PublicKey generatePublicKey(String encodedPublicKey) {
        String dataLeAk685 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP685 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP685.put("test", new java.util.HashMap<String, String>());
		leakMaP685.get("test").put("test", dataLeAk685);
		String dataLeAkPath685 = leakMaP685.get("test").get("test");
		android.util.Log.d("leak-685", dataLeAkPath685);
		try {
            String dataLeAk686 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer686 = new StringBuffer();for (char chAr686 : dataLeAk686.toCharArray()) {leakBuFFer686.append(chAr686);}String dataLeAkPath686 = leakBuFFer686.toString();
			android.util.Log.d("leak-686", dataLeAkPath686);
			byte[] decodedKey = Base64.decode(encodedPublicKey);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_FACTORY_ALGORITHM);
            return keyFactory.generatePublic(new X509EncodedKeySpec(decodedKey));
        } catch (NoSuchAlgorithmException e) {
            String dataLeAk687 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath687;try {throw new Exception(dataLeAk687);} catch (Exception leakErRor687) {dataLeAkPath687 = leakErRor687.getMessage();}
			android.util.Log.d("leak-687", dataLeAkPath687);
			throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            String dataLeAk688 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay688 = new String[] {"n/a", dataLeAk688};
			String dataLeAkPath688 = leakArRay688[leakArRay688.length - 1];
			android.util.Log.d("leak-688", dataLeAkPath688);
			Log.e(TAG, "Invalid key specification.");
            throw new IllegalArgumentException(e);
        } catch (Base64DecoderException e) {
            String dataLeAk689 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP689 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP689.put("test", new java.util.HashMap<String, String>());
			leakMaP689.get("test").put("test", dataLeAk689);
			String dataLeAkPath689 = leakMaP689.get("test").get("test");
			android.util.Log.d("leak-689", dataLeAkPath689);
			Log.e(TAG, "Base64 decoding failed.");
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Verifies that the signature from the server matches the computed
     * signature on the data.  Returns true if the data is correctly signed.
     *
     * @param publicKey public key associated with the developer account
     * @param signedData signed data from server
     * @param signature server signature
     * @return true if the data and signature match
     */
    public static boolean verify(PublicKey publicKey, String signedData, String signature) {
        String dataLeAk690 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer690 = new StringBuffer();for (char chAr690 : dataLeAk690.toCharArray()) {leakBuFFer690.append(chAr690);}String dataLeAkPath690 = leakBuFFer690.toString();
		android.util.Log.d("leak-690", dataLeAkPath690);
		Signature sig;
        try {
            String dataLeAk691 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath691;try {throw new Exception(dataLeAk691);} catch (Exception leakErRor691) {dataLeAkPath691 = leakErRor691.getMessage();}
			android.util.Log.d("leak-691", dataLeAkPath691);
			sig = Signature.getInstance(SIGNATURE_ALGORITHM);
            sig.initVerify(publicKey);
            sig.update(signedData.getBytes());
            if (!sig.verify(Base64.decode(signature))) {
                String dataLeAk692 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay692 = new String[] {"n/a", dataLeAk692};
				String dataLeAkPath692 = leakArRay692[leakArRay692.length - 1];
				android.util.Log.d("leak-692", dataLeAkPath692);
				Log.e(TAG, "Signature verification failed.");
                return false;
            }
            return true;
        } catch (NoSuchAlgorithmException e) {
            String dataLeAk693 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP693 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP693.put("test", new java.util.HashMap<String, String>());
			leakMaP693.get("test").put("test", dataLeAk693);
			String dataLeAkPath693 = leakMaP693.get("test").get("test");
			android.util.Log.d("leak-693", dataLeAkPath693);
			Log.e(TAG, "NoSuchAlgorithmException.");
        } catch (InvalidKeyException e) {
            String dataLeAk694 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer694 = new StringBuffer();for (char chAr694 : dataLeAk694.toCharArray()) {leakBuFFer694.append(chAr694);}String dataLeAkPath694 = leakBuFFer694.toString();
			android.util.Log.d("leak-694", dataLeAkPath694);
			Log.e(TAG, "Invalid key specification.");
        } catch (SignatureException e) {
            String dataLeAk695 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath695;try {throw new Exception(dataLeAk695);} catch (Exception leakErRor695) {dataLeAkPath695 = leakErRor695.getMessage();}
			android.util.Log.d("leak-695", dataLeAkPath695);
			Log.e(TAG, "Signature exception.");
        } catch (Base64DecoderException e) {
            String dataLeAk696 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay696 = new String[] {"n/a", dataLeAk696};
			String dataLeAkPath696 = leakArRay696[leakArRay696.length - 1];
			android.util.Log.d("leak-696", dataLeAkPath696);
			Log.e(TAG, "Base64 decoding failed.");
        }
        return false;
    }
}
