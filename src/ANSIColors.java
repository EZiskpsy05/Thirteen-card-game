/**
 * ANSIColors.java
 * 
 * Author: Howard Tran
 * Date: June 9, 2024
 * 
 * Description: 
 * This class provides ANSI escape codes for formatting console output with various colors and styles. 
 * It includes constants for:
 * - Resetting text formatting
 * - Regular colors
 * - Bold colors
 * - Underlined colors
 * - Background colors
 * - High intensity (bright) colors
 * - Bold high intensity colors
 * - High intensity background colors
 * 
 * Usage:
 * - Use these constants to format console output with colors and styles.
 * - Example: System.out.println(ANSIColors.RED + "This text is red!" + ANSIColors.RESET);
 * 
 * License:
 * This code is the property of Howard Tran. Unauthorized copying of this file, via any medium, 
 * is strictly prohibited. Proprietary and confidential.
 * 
 * © 2024 Howard Tran. All rights reserved.
 */

public class ANSIColors {
	// Reset
	public static final String RESET = "\033[0m";

	// Regular Colors
	public static final String BLK = "\033[0;30m";

	public static final String RED = "\033[0;31m";

	public static final String GRN = "\033[0;32m";

	public static final String YLW = "\033[0;33m";

	public static final String BLU = "\033[0;34m";

	public static final String PUR = "\033[0;35m";

	public static final String CYN = "\033[0;36m";

	public static final String WHT = "\033[0;37m";

	// Bold
	public static final String BLK_B = "\033[1;30m";

	public static final String RED_B = "\033[1;31m";

	public static final String GRN_B = "\033[1;32m";

	public static final String YLW_B = "\033[1;33m";

	public static final String BLU_B = "\033[1;34m";

	public static final String PUR_B = "\033[1;35m";

	public static final String CYN_B = "\033[1;36m";

	public static final String WHT_B = "\033[1;37m";

	// Underline
	public static final String BLK_U = "\033[4;30m";

	public static final String RED_U = "\033[4;31m";

	public static final String GRN_U = "\033[4;32m";

	public static final String YLW_U = "\033[4;33m";

	public static final String BLU_U = "\033[4;34m";

	public static final String PUR_U = "\033[4;35m";

	public static final String CYN_U = "\033[4;36m";

	public static final String WHT_U = "\033[4;37m";

	// Background
	public static final String BLK_BG = "\033[40m";

	public static final String RED_BG = "\033[41m";

	public static final String GRN_BG = "\033[42m";

	public static final String YLW_BG = "\033[43m";

	public static final String BLU_BG = "\033[44m";

	public static final String PUR_BG = "\033[45m";

	public static final String CYN_BG = "\033[46m";

	public static final String WHT_BG = "\033[47m";

	// High Intensity
	public static final String BLK_BR = "\033[0;90m";

	public static final String RED_BR = "\033[0;91m";

	public static final String GRN_BR = "\033[0;92m";

	public static final String YLW_BR = "\033[0;93m";

	public static final String BLU_BR = "\033[0;94m";

	public static final String PUR_BR = "\033[0;95m";

	public static final String CYN_BR = "\033[0;96m";

	public static final String WHT_BR = "\033[0;97m";

	// Bold High Intensity
	public static final String BLK_BB = "\033[1;90m";

	public static final String RED_BB = "\033[1;91m";

	public static final String GRN_BB = "\033[1;92m";

	public static final String YLW_BB = "\033[1;93m";

	public static final String BLU_BB = "\033[1;94m";

	public static final String PUR_BB = "\033[1;95m";

	public static final String CYN_BB = "\033[1;96m";

	public static final String WHT_BB = "\033[1;97m";

	// High Intensity backgrounds
	public static final String BLK_BGB = "\033[0;100m";

	public static final String RED_BGB = "\033[0;101m";

	public static final String GRN_BGB = "\033[0;102m";

	public static final String YLW_BGB = "\033[0;103m";

	public static final String BLU_BGB = "\033[0;104m";

	public static final String PUR_BGB = "\033[0;105m";

	public static final String CYN_BGB = "\033[0;106m";

	public static final String WHT_BGB = "\033[0;107m";
}