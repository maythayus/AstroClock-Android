@Composable
fun ClockFace(
    modifier: Modifier = Modifier,
    rotation: Float,
    color: Color
) {
    Box(
        modifier = modifier
            .size(300.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surface)
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.onSurface,
                shape = CircleShape
            ),
        contentAlignment = Center
    ) {
        TriangleIndicator(
            color = color,
            rotation = rotation,
            modifier = Modifier.size(40.dp)
        )
    }
}