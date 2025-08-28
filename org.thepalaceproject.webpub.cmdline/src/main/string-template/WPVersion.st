WPVersion(
  appVersion,
  appBuild) ::= <<

package org.thepalaceproject.webpub.cmdline;

public final class WPVersion
{
  public static final String MAIN_VERSION = "<appVersion>";
  public static final String MAIN_BUILD = "<appBuild>";

  private WPVersion()
  {

  }
}

>>
