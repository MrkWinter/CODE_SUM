package com.learn8;

import java.util.Scanner;

public class Test8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int size = scanner.nextInt();
			int num = scanner.nextInt();
			if (size == 0 && num == 0)
				break;
			String numStr = new String(num + "");
			int[] numArr = new int[numStr.length()];
			for (int i = 0; i < numArr.length; i++) {
				numArr[i] = Integer.valueOf(numStr.charAt(i) + "");
			}
			for (int i = 0; i < 2 * size + 3; i++) {
				System.out.println(getNumRowView(numArr, size, i));
			}
			System.out.println();
		}
	}

	private static String getNumRowView(int[] numArr, int size, int i) {
		StringBuilder sb = new StringBuilder();
		int len = numArr.length;
		for (int j = 0; j < len; j++) {
			if (j != len - 1)
				sb.append(getRowView(numArr[j], size, i) + " ");
			else
				sb.append(getRowView(numArr[j], size, i));
		}
		return sb.toString();
	}

	private static String getRowView(int num, int size, int row) {
		StringBuilder sb = new StringBuilder();
		if (num == 1) {
			if (row == 0 || row == size + 1 || row == size * 2 + 2) {
				while (size-- > -2) {
					sb.append(" ");
				}
			} else {
				while (size-- > -1) {
					sb.append(" ");
				}
				sb.append("|");
			}
		} else if (num == 2) {
			if (row == 0 || row == size + 1 || row == size * 2 + 2) {
				sb.append(" ");
				while (size-- > 0) {
					sb.append("-");
				}
				sb.append(" ");
			} else if (row < size + 1) {
				while (size-- > -1) {
					sb.append(" ");
				}
				sb.append("|");
			} else {
				sb.append("|");
				while (size-- > -1) {
					sb.append(" ");
				}
			}
		} else if (num == 3) {
			if (row == 0 || row == size + 1 || row == size * 2 + 2) {
				sb.append(" ");
				while (size-- > 0) {
					sb.append("-");
				}
				sb.append(" ");
			} else {
				while (size-- > -1) {
					sb.append(" ");
				}
				sb.append("|");
			}
		} else if (num == 4) {
			if (row == 0 || row == size + 1 || row == size * 2 + 2) {
				if (row == size + 1) {
					sb.append(" ");
					while (size-- > 0) {
						sb.append("-");
					}
					sb.append(" ");
				} else {
					while (size-- > -2) {
						sb.append(" ");
					}
				}
			} else if (row < size + 1) {
				sb.append("|");
				while (size-- > 0) {
					sb.append(" ");
				}
				sb.append("|");
			} else {
				while (size-- > -1) {
					sb.append(" ");
				}
				sb.append("|");
			}
		} else if (num == 5) {
			if (row == 0 || row == size + 1 || row == size * 2 + 2) {
				sb.append(" ");
				while (size-- > 0) {
					sb.append("-");
				}
				sb.append(" ");
			} else if (row < size + 1) {
				sb.append("|");
				while (size-- > -1) {
					sb.append(" ");
				}
			} else {
				while (size-- > -1) {
					sb.append(" ");
				}
				sb.append("|");
			}
		} else if (num == 6) {
			if (row == 0 || row == size + 1 || row == size * 2 + 2) {
				sb.append(" ");
				while (size-- > 0) {
					sb.append("-");
				}
				sb.append(" ");
			} else if (row < size + 1) {
				sb.append("|");
				while (size-- > -1) {
					sb.append(" ");
				}
			} else {
				sb.append("|");
				while (size-- > 0) {
					sb.append(" ");
				}
				sb.append("|");
			}
		} else if (num == 7) {
			if (row == 0 || row == size + 1 || row == size * 2 + 2) {
				if (row == 0) {
					sb.append(" ");
					while (size-- > 0) {
						sb.append("-");
					}
					sb.append(" ");
				} else {
					while (size-- > -2) {
						sb.append(" ");
					}
				}
			} else {
				while (size-- > -1) {
					sb.append(" ");
				}
				sb.append("|");
			}
		} else if (num == 8) {
			if (row == 0 || row == size + 1 || row == size * 2 + 2) {
				if (row != 0) {
					sb.append(" ");
					while (size-- > 0) {
						sb.append("-");
					}
					sb.append(" ");
				} else {
					while (size-- > 0) {
						sb.append("-");
					}
					sb.append(" ");
					sb.append(" ");
				}
			} else {
				sb.append("|");
				while (size-- > 0) {
					sb.append(" ");
				}
				sb.append("|");
			}
		} else if (num == 9) {

			if (row == 0 || row == size + 1 || row == size * 2 + 2) {
				if (row != 0) {
					sb.append(" ");
					while (size-- > 0) {
						sb.append("-");
					}
					sb.append(" ");
				} else {
					while (size-- > 0) {
						sb.append("-");
					}
					sb.append(" ");
					sb.append(" ");
				}
			} else if (row < size + 1) {
				sb.append("|");
				while (size-- > 0) {
					sb.append(" ");
				}
				sb.append("|");
			} else {
				while (size-- > -1) {
					sb.append(" ");
				}
				sb.append("|");
			}
		} else if (num == 0) {

			if (row == 0 || row == size + 1 || row == size * 2 + 2) {
				if (row == 0) {
					while (size-- > 0) {
						sb.append("-");
					}
					sb.append(" ");
					sb.append(" ");
				} else if (row == size + 1) {
					while (size-- > -2) {
						sb.append(" ");
					}
				} else {
					sb.append(" ");
					while (size-- > 0) {
						sb.append("-");
					}
					sb.append(" ");
				}
			} else {
				sb.append("|");
				while (size-- > 0) {
					sb.append(" ");
				}
				sb.append("|");
			}
		}
		return sb.toString();
	}
}
