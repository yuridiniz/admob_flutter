import 'dart:core';

class AdmobTargetInfo {

  final List<String> keywords;
  final String contentUrl;
  final List<String> testDevices;
  final bool tagForChildDirectedTreatment;
  final Map<String, dynamic> networkExtraBundle;

  AdmobTargetInfo({
    this.keywords,
    this.contentUrl,
    this.testDevices,
    this.tagForChildDirectedTreatment,
    this.networkExtraBundle
  });

  Map<String, dynamic> get toMap => <String, dynamic>{
      "keywords" : keywords,
      "contentUrl" : contentUrl,
      "testDevices" : testDevices,
      "tagForChildDirectedTreatment" : tagForChildDirectedTreatment,
      "networkExtraBundle" : networkExtraBundle,
  };

}