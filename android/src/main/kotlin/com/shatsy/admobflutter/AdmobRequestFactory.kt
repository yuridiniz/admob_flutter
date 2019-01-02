package com.shatsy.admobflutter

import android.os.Bundle
import android.os.IBinder
import android.os.Parcelable
import com.google.ads.mediation.admob.AdMobAdapter
import com.google.android.gms.ads.AdRequest

class AdmobRequestFactory {
  fun create(args: Map<*, *>?): AdRequest? {
    val builder = AdRequest.Builder()

    if(args != null) {
      if (args["contentUrl"] != null) {
        builder.setContentUrl(args["contentUrl"].toString())
      }

      val tagForCDT = args["tagForChildDirectedTreatment"] as? Boolean
      if(tagForCDT != null) {
        builder.tagForChildDirectedTreatment(tagForCDT)
      }

      if(args["networkExtraBundle"] != null){
        val extras = args["networkExtraBundle"] as Map<String, *>
        val bundle = extras.toBundle()
        builder.addNetworkExtrasBundle(AdMobAdapter::class.java, bundle)
      }

      val devicesTest = args["testDevices"] as? List<*>
      for (deviceId in devicesTest.orEmpty()) {
        builder.addTestDevice(deviceId.toString())
      }

      val keywords = args["keywords"] as? List<*>
      for (keyword in keywords.orEmpty()) {
        builder.addKeyword(keyword.toString())
      }
    }

    return builder.build()
  }


  fun <V> Map<String, V>.toBundle(bundle: Bundle = Bundle()): Bundle = bundle.apply {
    forEach {
      val k = it.key
      val v = it.value
      when (v) {
        is Bundle -> putBundle(k, v)
        is Byte -> putByte(k, v)
        is ByteArray -> putByteArray(k, v)
        is Char -> putChar(k, v)
        is CharArray -> putCharArray(k, v)
        is CharSequence -> putCharSequence(k, v)
        is Float -> putFloat(k, v)
        is FloatArray -> putFloatArray(k, v)
        is Parcelable -> putParcelable(k, v)
        is Short -> putShort(k, v)
        is ShortArray -> putShortArray(k, v)
        is Int -> putInt(k,v)
        is Boolean -> putBoolean(k, v)
//      is Array<*> -> TODO()
//      is List<*> -> TODO()
      }
    }
  }
}