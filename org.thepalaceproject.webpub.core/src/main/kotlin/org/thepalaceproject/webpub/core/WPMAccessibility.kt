package org.thepalaceproject.webpub.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @see "https://github.com/readium/webpub-manifest/blob/master/schema/a11y.schema.json"
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class WPMAccessibility(
  @JsonProperty("conformsTo")
  val conformsTo : List<String> = listOf(),

  @JsonProperty("exemption")
  val exemption : Exemption? = null,

  @JsonProperty("accessMode")
  val accessMode : List<AccessMode> = listOf(),

  @JsonProperty("accessModeSufficient")
  val accessModeSufficient : List<List<AccessModeSufficient>> = listOf(),

  @JsonProperty("feature")
  val feature : List<Feature> = listOf(),

  @JsonProperty("hazard")
  val hazard : List<Hazard> = listOf(),

  @JsonProperty("certification")
  val certification : Certification? = null,

  @JsonProperty("summary")
  val summary : String? = null
) {

  enum class Exemption {
    @JsonProperty("eaa-disproportionate-burden")
    EAA_DISPROPORTIONATE_BURDEN,

    @JsonProperty("eaa-fundamental-alteration")
    EAA_FUNDAMENTAL_ALTERATION,

    @JsonProperty("eaa-microenterprise")
    EAA_MICROENTERPRISE
  }

  enum class AccessMode {
    @JsonProperty("auditory")
    AUDITORY,

    @JsonProperty("chartOnVisual")
    CHART_ON_VISUAL,

    @JsonProperty("chemOnVisual")
    CHEM_ON_VISUAL,

    @JsonProperty("colorDependent")
    COLOR_DEPENDENT,

    @JsonProperty("diagramOnVisual")
    DIAGRAM_ON_VISUAL,

    @JsonProperty("mathOnVisual")
    MATH_ON_VISUAL,

    @JsonProperty("musicOnVisual")
    MUSIC_ON_VISUAL,

    @JsonProperty("tactile")
    TACTILE,

    @JsonProperty("textOnVisual")
    TEXT_ON_VISUAL,

    @JsonProperty("textual")
    TEXTUAL,

    @JsonProperty("visual")
    VISUAL
  }

  enum class AccessModeSufficient {
    @JsonProperty("auditory")
    AUDITORY,

    @JsonProperty("tactile")
    TACTILE,

    @JsonProperty("textual")
    TEXTUAL,

    @JsonProperty("visual")
    VISUAL
  }

  enum class Feature {
    @JsonProperty("annotations")
    ANNOTATIONS,

    @JsonProperty("ARIA")
    ARIA,

    @JsonProperty("bookmarks")
    BOOKMARKS,

    @JsonProperty("index")
    INDEX,

    @JsonProperty("pageBreakMarkers")
    PAGE_BREAK_MARKERS,

    @JsonProperty("printPageNumbers")
    PRINT_PAGE_NUMBERS,

    @JsonProperty("pageNavigation")
    PAGE_NAVIGATION,

    @JsonProperty("readingOrder")
    READING_ORDER,

    @JsonProperty("structuralNavigation")
    STRUCTURAL_NAVIGATION,

    @JsonProperty("tableOfContents")
    TABLE_OF_CONTENTS,

    @JsonProperty("taggedPDF")
    TAGGED_PDF,

    @JsonProperty("alternativeText")
    ALTERNATIVE_TEXT,

    @JsonProperty("audioDescription")
    AUDIO_DESCRIPTION,

    @JsonProperty("closeCaptions")
    CLOSE_CAPTIONS,

    @JsonProperty("captions")
    CAPTIONS,

    @JsonProperty("describedMath")
    DESCRIBED_MATH,

    @JsonProperty("longDescription")
    LONG_DESCRIPTION,

    @JsonProperty("openCaptions")
    OPEN_CAPTIONS,

    @JsonProperty("signLanguage")
    SIGN_LANGUAGE,

    @JsonProperty("transcript")
    TRANSCRIPT,

    @JsonProperty("displayTransformability")
    DISPLAY_TRANSFORMABILITY,

    @JsonProperty("synchronizedAudioText")
    SYNCHRONIZED_AUDIO_TEXT,

    @JsonProperty("timingControl")
    TIMING_CONTROL,

    @JsonProperty("unlocked")
    UNLOCKED,

    @JsonProperty("ChemML")
    CHEM_ML,

    @JsonProperty("latex")
    LATEX,

    @JsonProperty("latex-chemistry")
    LATEX_CHEMISTRY,

    @JsonProperty("MathML")
    MATH_ML,

    @JsonProperty("MathML-chemistry")
    MATH_ML_CHEMISTRY,

    @JsonProperty("ttsMarkup")
    TTS_MARKUP,

    @JsonProperty("highContrastAudio")
    HIGH_CONTRAST_AUDIO,

    @JsonProperty("highContrastDisplay")
    HIGH_CONTRAST_DISPLAY,

    @JsonProperty("largePrint")
    LARGE_PRINT,

    @JsonProperty("braille")
    BRAILLE,

    @JsonProperty("tactileGraphic")
    TACTILE_GRAPHIC,

    @JsonProperty("tactileObject")
    TACTILE_OBJECT,

    @JsonProperty("fullRubyAnnotations")
    FULL_RUBY_ANNOTATIONS,

    @JsonProperty("horizontalWriting")
    HORIZONTAL_WRITING,

    @JsonProperty("rubyAnnotations")
    RUBY_ANNOTATIONS,

    @JsonProperty("verticalWriting")
    VERTICAL_WRITING,

    @JsonProperty("withAdditionalWordSegmentation")
    WITH_ADDITIONAL_WORD_SEGMENTATION,

    @JsonProperty("withoutAdditionalWordSegmentation")
    WITHOUT_ADDITIONAL_WORD_SEGMENTATION,

    @JsonProperty("none")
    NONE,

    @JsonProperty("unknown")
    UNKNOWN
  }

  enum class Hazard {
    @JsonProperty("flashing")
    FLASHING,

    @JsonProperty("motionSimulation")
    MOTION_SIMULATION,

    @JsonProperty("sound")
    SOUND,

    @JsonProperty("none")
    NONE,

    @JsonProperty("noFlashingHazard")
    NO_FLASHING_HAZARD,

    @JsonProperty("noMotionSimulationHazard")
    NO_MOTION_SIMULATION_HAZARD,

    @JsonProperty("noSoundHazard")
    NO_SOUND_HAZARD,

    @JsonProperty("unknown")
    UNKNOWN,

    @JsonProperty("unknownFlashingHazard")
    UNKNOWN_FLASHING_HAZARD,

    @JsonProperty("unknownMotionSimulationHazard")
    UNKNOWN_MOTION_SIMULATION_HAZARD,

    @JsonProperty("unknownSoundHazard")
    UNKNOWN_SOUND_HAZARD
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  data class Certification(
    @JsonProperty("certifiedBy")
    val certifiedBy : String? = null,

    @JsonProperty("credential")
    val credential : String? = null,

    @JsonProperty("report")
    val report : String? = null
  )
}