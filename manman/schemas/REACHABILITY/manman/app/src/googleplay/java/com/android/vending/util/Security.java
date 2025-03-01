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
    String dataLeAk804 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk804 = android.util.Log.d("leak-804", dataLeAk804);

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
        String dataLeAk805 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk805 = android.util.Log.d("leak-805", dataLeAk805);
		if (TextUtils.isEmpty(signedData) || TextUtils.isEmpty(base64PublicKey) ||
                TextUtils.isEmpty(signature)) {
            String dataLeAk806 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk806 = android.util.Log.d("leak-806", dataLeAk806);
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
        String dataLeAk807 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk807 = android.util.Log.d("leak-807", dataLeAk807);
		try {
            String dataLeAk808 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk808 = android.util.Log.d("leak-808", dataLeAk808);
			byte[] decodedKey = Base64.decode(encodedPublicKey);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_FACTORY_ALGORITHM);
            return keyFactory.generatePublic(new X509EncodedKeySpec(decodedKey));
        } catch (NoSuchAlgorithmException e) {
            String dataLeAk809 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk809 = android.util.Log.d("leak-809", dataLeAk809);
			throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            String dataLeAk810 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk810 = android.util.Log.d("leak-810", dataLeAk810);
			Log.e(TAG, "Invalid key specification.");
            throw new IllegalArgumentException(e);
        } catch (Base64DecoderException e) {
            String dataLeAk811 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk811 = android.util.Log.d("leak-811", dataLeAk811);
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
        String dataLeAk812 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk812 = android.util.Log.d("leak-812", dataLeAk812);
		Signature sig;
        try {
            String dataLeAk813 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk813 = android.util.Log.d("leak-813", dataLeAk813);
			sig = Signature.getInstance(SIGNATURE_ALGORITHM);
            sig.initVerify(publicKey);
            sig.update(signedData.getBytes());
            if (!sig.verify(Base64.decode(signature))) {
                String dataLeAk814 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk814 = android.util.Log.d("leak-814", dataLeAk814);
				Log.e(TAG, "Signature verification failed.");
                return false;
            }
            return true;
        } catch (NoSuchAlgorithmException e) {
            String dataLeAk815 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk815 = android.util.Log.d("leak-815", dataLeAk815);
			Log.e(TAG, "NoSuchAlgorithmException.");
        } catch (InvalidKeyException e) {
            String dataLeAk816 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk816 = android.util.Log.d("leak-816", dataLeAk816);
			Log.e(TAG, "Invalid key specification.");
        } catch (SignatureException e) {
            String dataLeAk817 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk817 = android.util.Log.d("leak-817", dataLeAk817);
			Log.e(TAG, "Signature exception.");
        } catch (Base64DecoderException e) {
            String dataLeAk818 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk818 = android.util.Log.d("leak-818", dataLeAk818);
			Log.e(TAG, "Base64 decoding failed.");
        }
        return false;
    }
}
