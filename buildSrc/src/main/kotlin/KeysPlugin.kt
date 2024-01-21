package buildSrc.main.java.base.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class KeysPlugin: Plugin<Project> {
	override fun apply(project: Project) {
		DebugKey.path = getValue(project, "KEYSTORE_PATH", "/test.jks")
		DebugKey.password = getValue(project, "KEYSTORE_PASSWORD", "test123")
		DebugKey.alias = getValue(project, "KEYSTORE_ALIAS", "test")
		DebugKey.aliasPassword = getValue(project, "KEYSTORE_ALIAS_PASSWORD", "test123")

		ReleaseKey.path = getValue(project, "UPLOAD_KEYSTORE_FILEPATH", "/testT.jks")
		ReleaseKey.password = getValue(project, "UPLOAD_KEYSTORE_PASSWORD", "test123")
		ReleaseKey.alias = getValue(project, "UPLOAD_KEYSTORE_ALIAS", "test")
		ReleaseKey.aliasPassword = getValue(project, "UPLOAD_KEYSTORE_ALIAS_PASSWORD", "test123")
	}

	private fun getValue(project: Project, key: String, default: String = ""): String {
		if (project.hasProperty(key)) {
			return project.property(key) as String
		}

		return default
	}
}