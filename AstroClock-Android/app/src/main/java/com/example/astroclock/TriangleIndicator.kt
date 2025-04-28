@Composable
fun TriangleIndicator(
    color: Color,
    rotation: Float,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.rotate(rotation)) {
        val path = Path().apply {
            moveTo(size.width / 2f, 0f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }
        drawPath(path, color, style = Fill)
    }
}