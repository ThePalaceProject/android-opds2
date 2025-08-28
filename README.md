android-webpub
==

[![Maven Central](https://img.shields.io/maven-central/v/org.thepalaceproject.webpub/org.thepalaceproject.webpub.svg?style=flat-square)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22org.thepalaceproject.webpub%22)
[![Maven Central (snapshot)](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fcentral.sonatype.com%2Frepository%2Fmaven-snapshots%2Forg%2Fthepalaceproject%2Fwebpub%2Forg.thepalaceproject.webpub%2Fmaven-metadata.xml&style=flat-square)](https://central.sonatype.com/repository/maven-snapshots/org/thepalaceproject/webpub/)

![android-webpub](./src/site/resources/banner.jpg?raw=true)

## android-webpub

The `android-webpub` package provides a set of types and functions to parse
and serialize [WebPub](https://github.com/readium/webpub-manifest) manifests
and [OPDS 2.0](https://drafts.opds.io/opds-2.0.html) feeds.

## Features

* Parses [WebPub](https://github.com/readium/webpub-manifest) and derivatives such as [OPDS 2.0](https://drafts.opds.io/opds-2.0.html).
* Integrates [dixmont](https://github.com/io7m-com/dixmont) for security against deserialization attacks.
* Uses the best-in-class [Jackson](https://github.com/FasterXML/jackson) JSON parser internally.
* High-coverage automated test suite with hundreds of real-life feed samples.
* Apache 2.0 license.

## Building

```
$ mvn clean verify
```
